package com.my.buch.touristagency.database.connectiontodb;

/**
 * Exception that connected with work of {@link ConnectionPool}.
 */
public class ConnectionPoolException extends Exception {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectionPoolException(){
        super();
    }

    public ConnectionPoolException(String message){
        super(message);
    }

    public ConnectionPoolException(Exception e){
        super(e);
    }

    public ConnectionPoolException(String message, Exception e){
        super(message, e);
    }
}

