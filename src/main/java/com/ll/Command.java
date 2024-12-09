package com.ll;

public class Command {
    private final String actionName;

    public Command(String cmd){
        String[] split =cmd.split("\\?");
        this.actionName=split[0];
    }

    public String getActionName() {
        return actionName;
    }
}
