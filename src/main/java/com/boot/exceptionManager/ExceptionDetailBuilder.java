package com.boot.exceptionManager;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExceptionDetailBuilder {

    private String errorType;
    private String message;

    /**
     * Builds exception response body or message
     * @param errorType http status
     * @param message exception details
     * @return exceptionsDetails
     */
    public static ExceptionDetailBuilder of(String errorType, String message) {
        ExceptionDetailBuilder exceptionsDetails = new ExceptionDetailBuilder();
        exceptionsDetails.setErrorType( errorType);
        exceptionsDetails.setMessage( message);
        return exceptionsDetails;
    }
}
