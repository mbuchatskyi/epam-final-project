package com.my.buch.touristagency.database.listener;

import com.my.buch.touristagency.database.connectiontodb.ConnectionPool;
import com.my.buch.touristagency.database.connectiontodb.ConnectionPoolException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

/**
 * Initialize and destroys the Connection Pool at the same time as
 * ServletContext.
 */

@WebListener
public class ConnectionPoolListener implements ServletContextListener{

	private final static Logger LOG = Logger.getLogger(ConnectionPoolListener.class);
	/** The connection pool. */
    public static ConnectionPool connectionPool;
    /** The connection pool size*/
    private static final int POOL_SIZE = 20;

	public ConnectionPoolListener() {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ConnectionPool.init(POOL_SIZE);
		} catch (ConnectionPoolException e) {
			LOG.error(e.getMessage());
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			connectionPool.destroy();
		} catch (ConnectionPoolException e) {
			LOG.error(e.getMessage());
		}
	}
}
