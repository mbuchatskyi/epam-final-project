package com.my.buch.touristagency.model.entity;

import java.util.Date;

public class Order {
	/** Order id*/
	private long id;
	
	/** total_price */
	private int totalPrice;
	
	/** date_of_order */
	private Date dateOfOrder;
	
	/** order_status */
	private long orderStatusId;
	
	/** tour_id */
	private long tourId;
	
	/** user_id */
	private long userId;
	
	/**
     * Instantiates a new order.
     */
    public Order() {
    }
    
    /**
     * Gets the id.
     *
     * @return the id
     */
	public long getId() {
		return id;
	}

	/**
     * Sets the id.
     *
     * @param id the new id
     */
	public void setId(long id) {
		this.id = id;
	}

    /**
     * Gets the totalPrice.
     *
     * @return the totalPrice
     */
	public int getTotalPrice() {
		return totalPrice;
	}

	/**
     * Sets the total price.
     *
     * @param id the new total price
     */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

    /**
     * Gets the dateOfOrder.
     *
     * @return the dateOfOrder
     */
	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	/**
     * Sets the dateOfOrder.
     *
     * @param id the new dateOfOrder
     */
	public void setDateOfOrder(Date date) {
		this.dateOfOrder = date;
	}

    /**
     * Gets the orderStatusId.
     *
     * @return the orderStatusId
     */
	public long getOrderStatusId() {
		return orderStatusId;
	}

	/**
     * Sets the orderStatusId.
     *
     * @param id the new orderStatusId
     */
	public void setOrderStatusId(long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

    /**
     * Gets the tourTypeId.
     *
     * @return the tourTypeId
     */
	public long getTourId() {
		return tourId;
	}

	/**
     * Sets the tourId.
     *
     * @param id the new tourId
     */
	public void setTourId(long tourId) {
		this.tourId = tourId;
	}

    /**
     * Gets the userId.
     *
     * @return the userId
     */
	public long getUserId() {
		return userId;
	}

	/**
     * Sets the userId.
     *
     * @param id the new userId
     */
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
