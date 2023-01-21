package com.test.testTdd.chap07.userRegister;

import lombok.Data;

@Data
public class SpyEmailNotifier implements EmailNotifier{

    private boolean called;
    private String email;

    public boolean isCalled() {
        return called;
    }

    @Override
    public void sendRegisterEmail(String email) {
        this.called = true;
        this.email = email;
    }
}