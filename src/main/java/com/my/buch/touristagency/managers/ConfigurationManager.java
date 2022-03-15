package com.my.buch.touristagency.managers;

import java.util.ResourceBundle;

public class ConfigurationManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

	/**
	 * Instantiates a new configuration manager.
	 */
	private ConfigurationManager() {
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}

}
