package com.ll;

import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    public void t1(){
        Command cmd=new Command("삭제?id=10");
        assertThat(cmd.getActionName()).isEqualTo("삭제");
    }
}
