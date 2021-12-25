package com.ravi.hello.customexception;

public class StudentNotFindException extends RuntimeException {
    public StudentNotFindException() {
    }

    public StudentNotFindException(String msg) {
        super(msg);
    }
}
