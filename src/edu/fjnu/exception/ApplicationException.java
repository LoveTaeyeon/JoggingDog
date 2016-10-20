package edu.fjnu.exception;

/**
 * Created by ven_hxz on 16/4/3.
 * Application exception.
 */
public class ApplicationException extends Exception {
    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException() {
        super();
    }
}
