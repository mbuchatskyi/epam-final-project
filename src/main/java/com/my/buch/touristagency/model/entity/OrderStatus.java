package com.my.buch.touristagency.model.entity;

public enum OrderStatus {
	/** The registered order. */
    REGISTERED("registered"),
    
    /** The paided order. */
    PAIDED("paided"),
    
    /** The canceled order. */
    CANCELED("canceled");

    /** The name. */
    private String name;
    
    /**
     * Instantiates a new tour type.
     *
     * @param name the name
     */
    OrderStatus(String name){
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
