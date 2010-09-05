package com.meikai.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	private static MessageDigest MESSAGEDIGEST = null;
	/**
	 * Convert a string according to message digest algorithms md5.
	 *
	 * @param name
	 *            the orginal String need to be converted.
	 *
	 * @return the md5 value for the orginal String.
	 */
	public final static String md5(String name, String character) {
		if (MESSAGEDIGEST == null) {
			try {
				MESSAGEDIGEST = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		byte bytes[] = null;
		try {
			bytes = name.getBytes(character);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte hash[] = null;

		synchronized (MESSAGEDIGEST) {
			MESSAGEDIGEST.reset();
			MESSAGEDIGEST.update(bytes);

			hash = MESSAGEDIGEST.digest();
		}

		StringBuffer hexString = new StringBuffer(32);

		for (int i = 0; i < hash.length; i++) {
			if ((0xFF & hash[i]) < 0x10)
				hexString.append("0");

			hexString.append(Integer.toHexString(0xFF & hash[i]));
		}

		return hexString.toString();
	}

	public final static String md5(String name) {
		return md5(name,"gb2312");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(md5("123"));

	}

}
