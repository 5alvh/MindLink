package com.mindlink.exceptions.appointmentExeceptions;

public class AppontmentExeptions extends RuntimeException {
    public AppontmentExeptions(String message) {
        super(message);
    }

    public AppontmentExeptions(String message, Throwable cause) {
        super(message, cause);
    }
}
