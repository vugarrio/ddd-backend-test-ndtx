package com.vugarrio.backendTest.price.domain.exception;

public class DateWrongFormatException extends RuntimeException {
    public DateWrongFormatException(String date) {
        super("Format date " + date + " is wrong");
    }
}
