package com.my.buch.touristagency.logic;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ManagerTest {
	 /**
     * Configuration manager test.
     */
    @Test
    public void configurationManagerTest(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        Assert.assertNotNull(resourceBundle);
    }

    /**
     * Database manager test.
     */
    @Test
    public void messageManagerTest(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        Assert.assertNotNull(resourceBundle);
    }
}
