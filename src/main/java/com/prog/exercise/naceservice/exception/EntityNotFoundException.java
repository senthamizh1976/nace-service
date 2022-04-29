package com.prog.exercise.naceservice.exception;

public class EntityNotFoundException extends NaceGlobalException {
    public EntityNotFoundException() {
        super("Requested entity not present in the DB.", GlobalErrorCode.NAC_SERVICE_SYSTEM_EXCEPTION_ID);
    }
    public EntityNotFoundException (String message) {
        super(message, GlobalErrorCode.NAC_SERVICE_SYSTEM_EXCEPTION_ID);
    }
}