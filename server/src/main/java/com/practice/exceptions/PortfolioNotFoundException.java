package com.practice.exceptions;

public class PortfolioNotFoundException extends RuntimeException {
    public PortfolioNotFoundException(String instrumentoNoEncontrado) {
        super(instrumentoNoEncontrado);
    }
}
