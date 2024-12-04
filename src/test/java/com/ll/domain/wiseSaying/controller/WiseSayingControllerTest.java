package com.ll.domain.wiseSaying.controller;

import com.ll.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    //실패한 테스트 1개 만듦
    @Test
    @DisplayName("== 명언 앱 ==")

    public void t1(){
        String output= AppTest.run("종료");

        assertThat(output)
                .contains("== 명언 앱 ==");
    }

    //실패한 테스트 1개 만듦
    @Test
    @DisplayName("명령) ")
    public void t2(){
        String output=AppTest.run("""
                목록
                종료
                """);

        assertThat(output)
                .contains("명령) ");
    }

    //실패한 테스트 1개 만듦
    @Test
    @DisplayName("명령을 2번 이상 입력할 수 있습니다. ")
    public void t3() {
        String output = AppTest.run("""
                목록
                목록
                종료
                """);

        String[] split = output.split("명령\\)");
        assertThat(split).hasSize(4);
    }

    //실패한 테스트 1개 만듦
    @Test
    @DisplayName("등록을 입력하면 내용과 작가를 입력받는다. ")
    public void t4() {
        String output = AppTest.run("""
                    등록
                    현재를 사랑하라.
                    작자미상
                    """);

        assertThat(output)
                .contains("명언 : ")
                .contains("작가 : ");
    }

    //실패한 테스트 1개 만듦
    @Test
    @DisplayName("등록이 완료되면 명언번호가 출력된다. ")
    public void t5() {
        String output = AppTest.run("""
                    등록
                    현재를 사랑하라.
                    작자미상
                    """);

        assertThat(output)
                .contains("1번 명언이 등록되었습니다.");
    }

    //실패한 테스트 1개 만듦
    @Test
    @DisplayName("매번 생성되는 명언번호는 1씩 증가한다.")
    public void t6() {
        String output = AppTest.run("""
                    등록
                    현재를 사랑하라.
                    작자미상
                    등록
                    현재를 사랑하라.
                    작자미상
                    등록
                    현재를 사랑하라.
                    작자미상
                    """);

        assertThat(output)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.")
                .contains("3번 명언이 등록되었습니다.");
    }
}
