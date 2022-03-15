package com.my.buch.touristagency.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Validator {
	private final static Logger LOG = Logger.getLogger(Validator.class);

	private final static Pattern pLogin = Pattern.compile("([A-Za-zА-Яа-я0-9_-]){3,16}");

	private final static Pattern pPassword = Pattern.compile("([A-Za-zА-Яа-я0-9_-]){8,20}");

	private final static Pattern pEmail = Pattern
			.compile("([A-za-z0-9_\\.-]+)@([A-za-z0-9_\\.-]+)\\.([A-za-z\\.]{2,6})");

	private final static Pattern pName = Pattern.compile("([A-Za-zА-Яа-я]){2,25}");

	private final static Pattern pSurname = Pattern.compile("([A-Za-zА-Яа-я]){2,25}");

	/**
	 * Validate login.
	 *
	 * @param enterLogin the enter login
	 * @return true, if successful
	 */
	public static boolean validateLogin(String enterLogin) {
		Matcher mLogin = pLogin.matcher(enterLogin);
		LOG.debug("Validate Login: " + mLogin.matches());
		return mLogin.matches();
	}

	/**
	 * Validate password.
	 *
	 * @param enterPass the enter pass
	 * @return true, if successful
	 */
	public static boolean validatePassword(String enterPass) {
		Matcher mPassword = pPassword.matcher(enterPass);
		LOG.debug("Validate Password: " + mPassword.matches());
		return mPassword.matches();
	}

	/**
	 * Validate email.
	 *
	 * @param enterEmail the enter email
	 * @return true, if successful
	 */
	public static boolean validateEmail(String enterEmail) {
		Matcher mEmail = pEmail.matcher(enterEmail);
		LOG.debug("Validate Email: " + mEmail.matches());
		return mEmail.matches();
	}

	/**
	 * Validate name.
	 *
	 * @param enterName the enter name
	 * @return true, if successful
	 */
	public static boolean validateName(String enterName) {
		Matcher mName = pName.matcher(enterName);
		LOG.debug("Validate Name: " + mName.matches());
		return mName.matches();
	}

	/**
	 * Validate surname.
	 *
	 * @param enterSurname the enter surname
	 * @return true, if successful
	 */
	public static boolean validateSurname(String enterSurname) {
		Matcher mSurname = pSurname.matcher(enterSurname);
		LOG.debug("Validate Surname: " + mSurname.matches());
		return mSurname.matches();
	}
}
