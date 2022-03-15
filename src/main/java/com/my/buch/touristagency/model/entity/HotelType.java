package com.my.buch.touristagency.model.entity;

public enum HotelType {
	 /** The chain hotels. */
    CHAIN_HOTEL("chain_hotel"),
    
    /** The motels. */
    MOTEL("motel"),
    
    /** The resorts */
    RESORT("resort"),
	
	 /** The inns */
    INNS("inns");
	
    /** The name. */
    private String name;
    
    /**
     * Instantiates a new hotel type.
     *
     * @param name the name
     */
    HotelType(String name){
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
