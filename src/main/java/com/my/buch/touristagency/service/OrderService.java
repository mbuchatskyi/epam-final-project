package com.my.buch.touristagency.service;

import java.util.List;

import com.my.buch.touristagency.model.entity.Order;
import com.my.buch.touristagency.service.exceptionService.ServiceException;

public interface OrderService {
	/**
     * Check order.
     *
     * @param total price the total price
     * @param date_of_order the date of order
     * @param order_status_id the order_status
     * @param tour_id the tour
     * @param user_id the user who made order
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean checkOrder(int total_price, Long order_status_id, Long tour_id, Long user_id) throws ServiceException;
    
    /**
     * Find and render all tours.
     *
     * @return the list of tours
     * @throws ServiceException the service exception
     */
    List<Order> findAllOrders() throws ServiceException;
}
