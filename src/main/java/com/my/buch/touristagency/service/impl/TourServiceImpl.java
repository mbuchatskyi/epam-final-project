package com.my.buch.touristagency.service.impl;

import java.util.List;

import com.my.buch.touristagency.database.dao.TourDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.database.dao.impl.FactoryDAOImpl;
import com.my.buch.touristagency.model.entity.Tour;
import com.my.buch.touristagency.service.TourService;
import com.my.buch.touristagency.service.exceptionService.ServiceException;
import com.my.buch.touristagency.util.exceptionUtil.UtilException;

public class TourServiceImpl implements TourService {
	private final static long TOUR_ID_FOR_INSERT = 0L;
	
	private final static boolean IS_BURNING_INSERT = false;
	
	private final static boolean IS_DELETED_INSERT = false;
	
	private final static TourDAO tourDAOImpl = FactoryDAOImpl.getInstance().createTourDAO();

	@Override
	public List<Tour> findAllTours() throws ServiceException {
		try {
			return tourDAOImpl.findAllActualTours();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean checkCreateTour(String name, String description, int price, int people_amount,
			long hotel_id, long tour_type_id) throws ServiceException {
		boolean flag = false;
		flag = generalCreateTour(name, description, price, people_amount, hotel_id,
				tour_type_id);
		return flag;
	}

	/**
	 * General create tour.
	 *
	 * @param name          the enter name
	 * @param description   the enter description
	 * @param price         the enter price
	 * @param is_Burning    the enter is_Burning
	 * @param people_amount the enter people_amount
	 * @param is_deleted    the enter is_deleted
	 * @param hotel_id      the enter hotel_id
	 * @param tour_type_id  the enter tour_type_id
	 * @return true, if successful
	 * @throws ServiceException the service exception
	 */
	private boolean generalCreateTour(String name, String description, int price, int people_amount,
			 long hotel_id, long tour_type_id) throws ServiceException {
		boolean flag = false;
		try {
			Tour tour = new Tour();
			tour.setId(TOUR_ID_FOR_INSERT);
			tour.setName(name);
			tour.setDescription(description);
			tour.setPrice(price);
			tour.setBurning(IS_BURNING_INSERT);
			tour.setPeopleAmount(people_amount);
			tour.setDeleted(IS_DELETED_INSERT);
			tour.setHotelId(hotel_id);
			tour.setTourTypeId(tour_type_id);

			if (tourDAOImpl.insert(tour)) {
				flag = true;
			}

		} catch (DAOException e) {
			throw new ServiceException("Failed to create tour.", e);
		} catch (UtilException e) {
			throw new ServiceException(e);
		}
		return flag;
	}

	public Tour findTourById(Long id) {
		try {
			return tourDAOImpl.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
