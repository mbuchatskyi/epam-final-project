package com.my.buch.touristagency.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.my.buch.touristagency.util.exceptionUtil.UtilException;

public class PasswordCoding {
	/**
	 * Md5 encode.
	 *
	 * @param st the password
	 * @return the string
	 * @throws UtilException the business util exception
	 */
	public static String md5Encode(String st) throws UtilException {
		MessageDigest messageDigest;
		byte[] digest = new byte[0];
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(st.getBytes());
			digest = messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
			throw new UtilException("Failed to MD5 encode.", e);
		}

		BigInteger bigInt = new BigInteger(1, digest);
		String md5Hex = bigInt.toString(16);

		while (md5Hex.length() < 32) {
			md5Hex = "0" + md5Hex;
		}
		return md5Hex;
	}

}
