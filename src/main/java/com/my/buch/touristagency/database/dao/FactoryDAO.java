package com.my.buch.touristagency.database.dao;

/**
 * Provides a logic of instancing DAO objects.
 */
public interface FactoryDAO {

	/**
     * Gives {@link UserDAO} implementation.
     *
     * @return UserDAO implementation
     */
	public UserDAO createUserDAO();
	
	/**
     * Gives {@link OrderDAO} implementation.
     *
     * @return OrderDAO implementation
     */
	public OrderDAO createOrderDAO();
	
	/**
     * Gives {@link TourDAO} implementation.
     *
     * @return TourDAO implementation
     */
	public TourDAO createTourDAO();
	
	/**
     * Gives {@link DiscountDAO} implementation.
     *
     * @return DiscountDAO implementation
     */
	public DiscountDAO createDiscountDAO();
}
