package com.my.buch.touristagency.model.entity;

public class User {
	/** User id*/
	private long id;
	
	/** login */
	private String login;
	
	/** password */
	private String password;
	
	/** role_id */
	private int roleId;
	
	/** email */
	private String email;
	
	/** first_name */
	private String firstName;
	
	/** last_name */
	private String lastName;
	
	/** is_blocked */
	private boolean isBlocked;
	
	/** discount */
	private int discount;
	
	/**
     * Instantiates a new user.
     */
    public User() {
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
     * Gets the login.
     *
     * @return the login
     */
	public String getLogin() {
		return login;
	}

	/**
     * Sets the login.
     *
     * @param id the new login
     */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
     * Gets the password.
     *
     * @return the password
     */
	public String getPassword() {
		return password;
	}

	/**
     * Sets the password.
     *
     * @param id the new password
     */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
     * Gets the roleId.
     *
     * @return the roleId
     */
	public int getRoleId() {
		return roleId;
	}

	/**
     * Sets the roleId.
     *
     * @param id the new roleId
     */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
    
    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
	public String getFirstName() {
		return firstName;
	}

	 /**
     * Sets the first name.
     *
     * @param firstName the first name
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
     * Gets the last name.
     *
     * @return the last name
     */
	public String getLastName() {
		return lastName;
	}

	/**
     * Sets the last name.
     *
     * @param lastName the last name
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
     * Gets the isBlocked.
     *
     * @return the isBlocked
     */
	public boolean getIsBlocked() {
		return isBlocked;
	}
	
	
	/**
     * Sets the isBlocked.
     *
     * @param isBlocked the isBlocked
     */
	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	/**
     * Gets the discount.
     *
     * @return the discount
     */
	public int getDiscount() {
		return discount;
	}

	/**
     * Sets the discount
     *
     * @param discount the discount
     */
	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
