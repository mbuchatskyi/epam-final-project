package com.my.buch.touristagency.service;

import com.my.buch.touristagency.model.entity.User;
import com.my.buch.touristagency.service.exceptionService.ServiceException;

public interface DiscountService {
	/**
     * Check edit discount's step and max.
     *
     * @param step the entered step by admin
     * @param max the entered max by admin
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean checkEditDiscount(int step, int max) throws ServiceException; 
    
    /**
     * Check edit user's discount.
     *
     * @param user the user who made the order
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean checkEditUserDiscount(User user) throws ServiceException;
}
