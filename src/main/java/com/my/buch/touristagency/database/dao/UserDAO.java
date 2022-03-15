package com.my.buch.touristagency.database.dao;

import com.my.buch.touristagency.model.entity.User;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;

import java.util.List;

/**
 * Provides a DAO-logic for the {@link User} entity.
 */
public interface UserDAO {

    /**
     * Inserts a new user into a data source.
     *
     * @param user a user object for insertion
     * @return true, if operation was successfully completed
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    boolean insert(User user) throws DAOException;

    /**
     * Updates a user in a data source.
     *
     * @param user a user object for update
     * @return true, if operation was successfully completed
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    boolean update(User user) throws DAOException;

    /**
     * Gives a user from a data source by id.
     *
     * @param id a id of a desired user
     * @return a user object containing the necessary data
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    User findById(long id) throws DAOException;
    
    /**
     * Gives a user from a data source by login.
     *
     * @param name a login of a desired user
     * @return a user object containing the necessary data
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    User findByName(String name) throws DAOException;
    
    /**
     * Gives a list of all users from a data source.
     *
     * @return a {@link List} of users
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    List<User> findAllUsers() throws DAOException;
}
