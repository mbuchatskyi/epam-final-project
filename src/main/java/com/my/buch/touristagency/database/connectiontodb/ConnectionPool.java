package com.my.buch.touristagency.database.connectiontodb;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;

/**
 * The Class ConnectionPool.
 */
public class ConnectionPool {

    /**
     * The constant LOG.
     */
    private final static Logger LOG = Logger.getLogger(ConnectionPool.class);

    /**
     * The connection queue.
     */
    private ArrayBlockingQueue<ProxyConnection> connectionQueue;

    private static final String KEY_RESOURCE_PATH = "database.properties";

    private static final String KEY_DRIVER_NAME = "driver-name";

    private static final String KEY_CONNECTION_STRING = "connection-string";

    /**
     * Instantiates a new connection pool.
     *
     * @param poolSize the pool size
     * @throws ConnectionPoolException the connection pool exception
     */
    private ConnectionPool(final int poolSize) throws ConnectionPoolException {
        try {
           makeConnection(poolSize);
           System.out.println("Connection pool was created successfully");
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Failed to register driver.", e);
        } catch (IOException e) {
            throw new ConnectionPoolException("Failed to read database properties.", e);
        } catch (SQLException e) {
            throw new ConnectionPoolException("Failed to get connection.", e);
        }
    }

    /**
     * Nested class ConnectionPoolHolder.
     */
    private static class ConnectionPoolHolder {
        private static ConnectionPool HOLDER_INSTANCE;
    }

    public static void init(final int poolSize) throws ConnectionPoolException {
        ConnectionPoolHolder.HOLDER_INSTANCE = new ConnectionPool(poolSize);
    }

    /**
     * Gets the instance.
     *
     * @return the ConnectionPoolHolder instance
     * @throws ConnectionPoolException 
     */
    public static ConnectionPool getInstance() throws ConnectionPoolException {
    	return ConnectionPoolHolder.HOLDER_INSTANCE;
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     * @throws ConnectionPoolException the connection pool exception
     */
    public Connection getConnection() throws ConnectionPoolException {
        try {
            return connectionQueue.take();
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Failed to take connection from pool.", e);
        }
    }

    /**
     * Gets the pool size.
     *
     * @return the pool size
     */
    public int getPoolSize() {
        return connectionQueue.size();
    }

    /**
     * Close all connections.
     *
     * @throws ConnectionPoolException the connection pool exception
     */
    public void destroy() throws ConnectionPoolException {
        int count = 0;
        for (ProxyConnection connection : connectionQueue) {
            try {
                connection.closeConnection();
                count++;
            } catch (SQLException e) {
                throw new ConnectionPoolException("Failed to close connection.", e);
            }
        }
        LOG.info("Connections in the amount of " + count + " pieces successfully closed.");
    }

    /**
     * Make connections.
     *
     * @param POOL_SIZE the pool size
     * @throws IOException the IO exception
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException the SQL exception
     */
    private void makeConnection(final int POOL_SIZE) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(KEY_RESOURCE_PATH));
        connectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);
        Class.forName(properties.getProperty(KEY_DRIVER_NAME));
        for (int i = 0; i < POOL_SIZE; i++) {
            ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(properties.getProperty(KEY_CONNECTION_STRING), properties));
            connectionQueue.offer(connection);
        }
    }

    /**
     * Close connection.
     *
     * @param connection the connection
     */
    private void closeConnection(ProxyConnection connection) {
        LOG.info("Queue before close: " + connectionQueue.size());
        connectionQueue.offer(connection);
        LOG.info("Queue after close: " + connectionQueue.size());
    }

    /**
     * The Inner Class ProxyConnection.
     */
    private class ProxyConnection implements Connection{

        /** The connection. */
        private Connection connection;

        /**
         * Instantiates a new proxy connection.
         *
         * @param connection the connection
         */
        ProxyConnection(Connection connection) {
            this.connection = connection;
        }

        @Override
        public Statement createStatement() throws SQLException {
            return connection.createStatement();
        }

        /**
         * Close connection.
         *
         * @throws SQLException the SQL exception
         */
        private void closeConnection() throws SQLException {
            connection.close();
        }

        @Override
        public void close() throws SQLException {
            ConnectionPool.this.closeConnection(this);
        }

        @Override
        public void commit() throws SQLException {
            connection.commit();
        }

        @Override
        public boolean isClosed() throws SQLException {
            return connection.isClosed();
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return null;
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return false;
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {
        }

        @Override
        public String getCatalog() throws SQLException {
            return null;
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return 0;
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return null;
        }

        @Override
        public void clearWarnings() throws SQLException {
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return null;
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return null;
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return null;
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        }

        @Override
        public void setHoldability(int holdability) throws SQLException {
        }

        @Override
        public int getHoldability() throws SQLException {
            return 0;
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return null;
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return null;
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return null;
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return null;
        }

        @Override
        public Clob createClob() throws SQLException {
            return null;
        }

        @Override
        public Blob createBlob() throws SQLException {
            return null;
        }

        @Override
        public NClob createNClob() throws SQLException {
            return null;
        }
        
        @Override
        public SQLXML createSQLXML() throws SQLException {
            return null;
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            return false;
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {

        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            return null;
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return null;
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return null;
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return null;
        }

        @Override
        public void setSchema(String schema) throws SQLException {

        }

        @Override
        public String getSchema() throws SQLException {
            return null;
        }

        @Override
        public void abort(Executor executor) throws SQLException {

        }

        @Override
        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return 0;
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return connection.prepareStatement(sql);
        }
        
        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return null;
        }

        @Override
        public String nativeSQL(String sql) throws SQLException {
            return null;
        }

        @Override
        public void rollback() throws SQLException {
            connection.rollback();
        }

        @Override
        public void setAutoCommit(boolean flag) throws SQLException {
            connection.setAutoCommit(flag);
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return false;
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }
    }
}
