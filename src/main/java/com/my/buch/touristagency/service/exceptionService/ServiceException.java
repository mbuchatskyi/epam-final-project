package com.my.buch.touristagency.service.exceptionService;

public class ServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 /** Constructs a new ServiceException with {@code null} as its
     * detail message. 
     */
    public ServiceException() {
        super();
    }

    /** Constructs a new Service exception with the specified detail message.
     * The cause is not initialized.
     *
     * @param   message   the detail message.
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Constructs a new Service exception with the specified detail message and
     * cause. 
     *
     * @param  message the detail message
     * @param  cause the cause 
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /** Constructs a new Service exception with the specified cause and a
     * detail message of {@code (cause==null ? null : cause.toString())}
     * 
     * @param  cause the cause
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new Service exception with the specified detail
     * message, cause, suppression enabled or disabled, and writable
     * stack trace enabled or disabled.
     *
     * @param  message the detail message.
     * @param cause the cause.
     * @param enableSuppression whether or not suppression is enabled
     *                          or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     *
     */
    protected ServiceException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
