package com.my.buch.touristagency.command.exceptionCommand;

public class CommandException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 /**
     * Instantiates a new command exception.
     *
     */
    public CommandException() {
        super();
    }
    
    /**
     * Instantiates a new command exception.
     *
     * @param message the message
     */
    public CommandException(String message) {
        super(message);
    }
    
    /**
     * Instantiates a new command exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Instantiates a new command exception.
     *
     * @param cause the cause
     */
    public CommandException(Throwable cause) {
        super(cause);
    }
}
