package com.my.buch.touristagency.database.dao.impl;

import com.my.buch.touristagency.database.dao.DiscountDAO;
import com.my.buch.touristagency.database.dao.FactoryDAO;
import com.my.buch.touristagency.database.dao.OrderDAO;
import com.my.buch.touristagency.database.dao.TourDAO;
import com.my.buch.touristagency.database.dao.UserDAO;

/**
 * Provides a logic of instancing DAO objects.
 */
public class FactoryDAOImpl implements FactoryDAO {
	private static FactoryDAOImpl factoryDAOImpl = new FactoryDAOImpl();

	private FactoryDAOImpl() {
	}

	/**
	 * Returns the instance of the DAOFactory.
	 * 
	 * @return the instance of the DAOFactory
	 */
	public static FactoryDAOImpl getInstance() {
		return factoryDAOImpl;
	}

	/**
	 * Gives {@link UserDAO} implementation.
	 *
	 * @return UserDAO implementation
	 */
	@Override
	public UserDAO createUserDAO() {
		return new UserDAOImpl();
	}

	/**
	 * Gives {@link OrderDAO} implementation.
	 *
	 * @return OrderDAO implementation
	 */
	@Override
	public OrderDAO createOrderDAO() {
		return new OrderDAOImpl();
	}

	/**
	 * Gives {@link TourDAO} implementation.
	 *
	 * @return TourDAO implementation
	 */
	@Override
	public TourDAO createTourDAO() {
		return new TourDAOImpl();
	}

	/**
	 * Gives {@link DiscountDAO} implementation.
	 *
	 * @return DiscountDAO implementation
	 */
	@Override
	public DiscountDAO createDiscountDAO() {
		return new DiscountDAOImpl();
	}
}
