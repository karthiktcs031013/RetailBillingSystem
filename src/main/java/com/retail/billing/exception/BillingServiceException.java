package com.retail.billing.exception;

public class BillingServiceException extends RuntimeException {

    public BillingServiceException(String message, Throwable cause) {
        super(message,cause);
    }
}
