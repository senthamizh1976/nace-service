package com.prog.exercise.naceservice.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NaceGlobalException extends RuntimeException {

    private String code;
    private String message;

    public NaceGlobalException(String message) {
        super(message);
    }
}