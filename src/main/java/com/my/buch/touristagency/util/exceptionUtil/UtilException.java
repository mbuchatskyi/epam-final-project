package com.my.buch.touristagency.util.exceptionUtil;

public class UtilException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 /** Constructs a new Util exception with {@code null} as its
     * detail message. 
     */
    public UtilException() {
        super();
    }

    /** Constructs a new Util exception with the specified detail message.
     * The cause is not initialized.
     *
     * @param   message   the detail message.
     */
    public UtilException(String message) {
        super(message);
    }

    /**
     * Constructs a new Util exception with the specified detail message and
     * cause. 
     *
     * @param  message the detail message
     * @param  cause the cause 
     */
    public UtilException(String message, Throwable cause) {
        super(message, cause);
    }

    /** Constructs a new Util exception with the specified cause and a
     * detail message of {@code (cause==null ? null : cause.toString())}
     * 
     * @param  cause the cause
     */
    public UtilException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new Util exception with the specified detail
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
    protected UtilException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
