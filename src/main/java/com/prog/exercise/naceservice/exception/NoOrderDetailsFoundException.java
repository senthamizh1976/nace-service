package com.prog.exercise.naceservice.exception;

public class NoOrderDetailsFoundException extends NaceGlobalException {
    public NoOrderDetailsFoundException(String message, String code) {
        super(message, code);
    }
}