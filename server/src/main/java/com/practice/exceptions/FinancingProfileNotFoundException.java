package com.practice.exceptions;

public class FinancingProfileNotFoundException extends RuntimeException {
    public FinancingProfileNotFoundException(String format) {
        super(format);
    }
}
