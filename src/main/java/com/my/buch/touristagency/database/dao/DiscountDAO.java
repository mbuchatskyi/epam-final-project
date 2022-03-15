package com.my.buch.touristagency.database.dao;

import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.model.entity.Discount;

/**
 * Provides a DAO-logic for the {@link Discount} entity.
 */
public interface DiscountDAO {

	/**
     * Update a step of discount increasing and max discount value.
     *
     * @param discount the discount object which will be updated
     * @return true, if operation was successfully completed
     * @throws DAOException the DAO exception
     */
    boolean update(Discount discount) throws DAOException;
    
    /**
     * Get a step and max value of discount from database.
     *
     * @return true, if operation was successfully completed
     * @throws DAOException the DAO exception
     */
    boolean getDiscountFromDB() throws DAOException;
}
