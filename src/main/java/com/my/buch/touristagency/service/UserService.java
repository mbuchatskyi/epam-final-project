package com.my.buch.touristagency.service;

import com.my.buch.touristagency.model.entity.User;
import com.my.buch.touristagency.service.exceptionService.ServiceException;

/**
 * The Interface UserService.
 */
public interface UserService {

    /**
     * Find user by id.
     *
     * @param id the user's id
     * @return the user
     * @throws ServiceException the service exception
     */
    User findUserById(Long id) throws ServiceException;
    
    /**
     * Find user by login.
     *
     * @param login the user's login
     * @return the user
     * @throws ServiceException the service exception
     */
    User findUserByName(String login) throws ServiceException;

    /**
     * Check validation and create user.
     *
     * @param enterLogin the enter login
     * @param enterPassword the enter password
     * @param enterEmail the enter email
     * @param enterFirstName the enter first name
     * @param enterLastName the enter last name
     * @param enterRoleId the enter roleid
     * @param enterIsBlocked the enter block
     * @param enterDiscount the enter discount
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean checkCreateUser(String enterLogin, String enterPassword, String enterEmail, String enterFirstName, String enterLastName, int enterRoleId, boolean enterIsBlocked, int enterDiscount) throws ServiceException;

    /**
     * Check login.
     *
     * @param enterLogin the enter login
     * @param enterPassword the enter pass
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean checkLogin(String enterLogin, String enterPassword) throws ServiceException;

    /**
     * Check register.
     *
     * @param enterLogin the enter login
     * @param enterPassword the enter password
     * @param enterEmail the enter email
     * @param enterFirstName the enter first name
     * @param enterLastname the enter last name
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean checkRegister(String enterLogin, String enterPassword, String enterEmail, String enterFirstName, String enterLastName) throws ServiceException;
}

