package com.my.buch.touristagency.database.dao;

import com.my.buch.touristagency.model.entity.Order;

import java.util.List;

import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;

/**
 * Provides a DAO-logic for the {@link Order} entity.
 */
public interface OrderDAO {

    /**
     * Inserts a new order into a data source.
     *
     * @param order a order object for insertion
     * @return true, if operation was successfully completed
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    boolean insert(Order order) throws DAOException; 
    
    /**
     * Updates a order in a data source.
     *
     * @param order a order object for update
     * @return true, if operation was successfully completed
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    boolean update(Order order) throws DAOException;
    
    /**
     * Gives a list of all orders from a data source.
     *
     * @return a {@link List} of or
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    List<Order> findAllOrders() throws DAOException;
    
    /**
     * Gives a order from a data source by id.
     *
     * @param id a id of a desired order
     * @return a order object containing the necessary data
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    Order findById(long id) throws DAOException;
}
