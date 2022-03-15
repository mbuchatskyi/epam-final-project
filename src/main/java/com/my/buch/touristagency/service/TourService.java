package com.my.buch.touristagency.service;

import java.util.List;

import com.my.buch.touristagency.model.entity.Tour;
import com.my.buch.touristagency.service.exceptionService.ServiceException;

public interface TourService {

	 /**
     * Check create tour.
     *
     * @param name the enter name
     * @param description the enter description
     * @param price the enter price
     * @param is_Burning the enter is_Burning
     * @param people_amount the enter people_amount
     * @param is_deleted the enter is_deleted
     * @param hotel_id the enter hotel_id
     * @param tour_type_id the enter tour_type_id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean checkCreateTour(String name, String description, int price, int people_amount, long hotel_id, long tour_type_id) throws ServiceException;
       
    /**
     * Find and render all tours.
     *
     * @return the list of tours
     * @throws ServiceException the service exception
     */
    List<Tour> findAllTours() throws ServiceException;
}
