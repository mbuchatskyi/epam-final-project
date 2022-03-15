package com.my.buch.touristagency.model.entity;

public class Tour {
	/** Tour id */
	private long id;
	
	/** name */
	private String name;
	
	/** description */
	private String description;
	
	/** price */
	private int price;
	
	/** isBurning */
	private boolean isBurning;
	
	/** peopleAmount */
	private int peopleAmount;
	
	/** isDeleted */
	private boolean isDeleted;
	
	/** hotel_id */
	private long hotelId;
	
	/** tour_type_id */
	private long tourTypeId;

	/**
     * Instantiates a new tour.
     */
    public Tour() {
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
     * Gets the name.
     *
     * @return the name
     */
	public String getName() {
		return name;
	}

	/**
     * Sets the name.
     *
     * @param id the new name
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Gets the description.
     *
     * @return the description
     */
	public String getDescription() {
		return description;
	}
	
	/**
     * Sets the description.
     *
     * @param id the new description
     */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * Gets the price.
     *
     * @return the price
     */
	public int getPrice() {
		return price;
	}

	/**
     * Sets the price.
     *
     * @param id the new price
     */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
     * Gets the isBurning.
     *
     * @return the isBurning
     */
	public boolean getIsBurning() {
		return isBurning;
	}

	/**
     * Sets the isBurning.
     *
     * @param id the new isBurning
     */
	public void setBurning(boolean isBurning) {
		this.isBurning = isBurning;
	}

	/**
     * Gets the amountPeople.
     *
     * @return the amount of people for the tour
     */
	public int getPeopleAmount() {
		return peopleAmount;
	}
	/**
     * Sets the amountPeople.
     *
     * @param id the new amountPeople
     */
	public void setPeopleAmount(int peopleAmount) {
		this.peopleAmount = peopleAmount;
	}
	
	/**
     * Gets the isDeleted.
     *
     * @return the isDeleted
     */
	public boolean getIsDeleted() {
		return isDeleted;
	}
	/**
     * Sets the isDeleted.
     *
     * @param id the new isDeleted
     */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
     * Gets the hotelId.
     *
     * @return the hotelId
     */
	public long getHotelId() {
		return hotelId;
	}

	/**
     * Sets the hotelId.
     *
     * @param id the new hotelId
     */
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	/**
     * Gets the tourTypeId.
     *
     * @return the tourTypeId
     */
	public long getTourTypeId() {
		return tourTypeId;
	}
	
	/**
     * Sets the tourTypeId.
     *
     * @param id the new tourTypeId
     */
	public void setTourTypeId(long tourTypeId) {
		this.tourTypeId = tourTypeId;
	}
}
