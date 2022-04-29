package com.prog.exercise.naceservice.exception;

public class InvalidRequestException extends NaceGlobalException {
    public InvalidRequestException(String message, String code) {
        super(message, code);
    }
}