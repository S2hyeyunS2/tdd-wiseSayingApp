package com.ll.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {
    //먼저 Scanner 만드는거 Test
    //실패한 테스트 1개 만듦
    //TestUtil은 Test환경에서만 사용
    @Test
    @DisplayName("TestUtil.getScanner()")
    public void t1(){
        Scanner scanner = TestUtil.getScanner("""
                등록
                나의 죽음을 적들에게 알리지 말라!
                이순신
                """.stripIndent().trim());

        String cmd=scanner.nextLine();
        String content=scanner.nextLine();
        String author=scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("나의 죽음을 적들에게 알리지 말라!");
        assertThat(author).isEqualTo("이순신");
    }

    //실패한 테스트 1개 만듦
    @Test
    @DisplayName("TestUtil.setOutToByteArray()")
    public void t1(){
        // 이 시점 이후로 출력을 해도 출력이 안됨
        ByteArrayOutputStream byteArrayOutputStream=TestUtil.setOutToByteArray();

        System.out.println("2 / 이순신 /  나의 죽음을 적들에게 알리지 말라!");

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream); //clear가 byteStream을 clear하고 원상태로 돌려라

        //위에 println과 assertThat 내용은 같아야 한다.
        assertThat(out).isEqualTo("2 / 이순신 / 나의 죽음을 적들에게 알리지 말라!");
        System.out.println("이제는 화면에 출력됩니다.");
    }
}
