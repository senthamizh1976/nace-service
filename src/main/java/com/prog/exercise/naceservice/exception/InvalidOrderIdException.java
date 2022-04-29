package com.prog.exercise.naceservice.exception;

public class InvalidOrderIdException extends NaceGlobalException {
    public InvalidOrderIdException(String message, String code) {
        super(message, code);
    }
}