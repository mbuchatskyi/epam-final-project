package com.my.buch.touristagency.database.dao;

import com.my.buch.touristagency.model.entity.Tour;

import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import java.util.List;

/**
 * Provides a DAO-logic for the {@link Tour} entity.
 */
public interface TourDAO {

	 /**
     * Inserts a new tour into a data source.
     *
     * @param tour a tour object for insertion
     * @return true, if operation was successfully completed
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    boolean insert(Tour tour) throws DAOException;

    /**
     * Updates a tour in a data source.
     *
     * @param tour a tour object for update
     * @return true, if operation was successfully completed
     * @throws DAOException in case of some exception with
     *                      a data source or a connection with it
     */
    boolean update(Tour tour) throws DAOException;

    /**
     * Find all non deleted tours.
     *
     * @return the list of actual tours
     * @throws DAOException the DAO exception
     */
    List<Tour> findAllActualTours() throws DAOException;
   
    /**
     * Find tour by id.
     *
     * @param id the tour id
     * @return the tour
     * @throws DAOException the DAO exception
     */
	Tour findById(Long id) throws DAOException;
}
