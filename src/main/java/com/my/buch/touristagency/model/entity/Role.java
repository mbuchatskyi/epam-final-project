package com.my.buch.touristagency.model.entity;

public enum Role {
	 /** User */
	USER("user"),
    
    /** Manager*/
    MANAGER("manager"),
    
    /** Admin */
    ADMIN("admin");

    /** The name. */
    private String name;
    
    /**
     * Instantiates a new Role.
     *
     * @param name the name
     */
    Role(String name){
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
