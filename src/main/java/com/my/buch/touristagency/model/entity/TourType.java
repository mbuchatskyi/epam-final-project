package com.my.buch.touristagency.model.entity;

public enum TourType {
    /** The vacations. */
    VACATION("vacation"),
    
    /** The trips. */
    TRIP("trip"),
    
    /** The shoppings. */
    SHOPPING("shopping");

    /** The name. */
    private String name;
    
    /**
     * Instantiates a new tour type.
     *
     * @param name the name
     */
    TourType(String name){
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
