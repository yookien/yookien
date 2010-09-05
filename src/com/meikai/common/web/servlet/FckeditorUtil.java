package com.meikai.common.web.servlet;

import java.util.ArrayList;
import java.util.Hashtable;

public class FckeditorUtil {


	/**
	 * Helper function to convert the configuration string to an ArrayList.
	 */

	public static ArrayList stringToArrayList(String str) {
		String[] strArr = str.split("\\|");

		ArrayList tmp = new ArrayList();
		if (str.length() > 0) {
			for (int i = 0; i < strArr.length; ++i) {
				tmp.add(strArr[i].toLowerCase());
			}
		}
		return tmp;
	}

	/**
	 * Helper function to verify if a file extension is allowed or not allowed.
	 */

	public static boolean extIsAllowed(Hashtable allowedExtensions, Hashtable deniedExtensions, String fileType, String ext) {

		ext = ext.toLowerCase();

		ArrayList allowList = (ArrayList) allowedExtensions.get(fileType);
		ArrayList denyList = (ArrayList) deniedExtensions.get(fileType);

		if (allowList.size() == 0)
			if (denyList.contains(ext))
				return false;
			else
				return true;

		if (denyList.size() == 0)
			if (allowList.contains(ext))
				return true;
			else
				return false;

		return false;
	}

	/*
	 * This method was fixed after Kris Barnhoorn (kurioskronic) submitted SF bug #991489
	 */
  	public static String getNameWithoutExtension(String fileName) {
    		return fileName.substring(0, fileName.lastIndexOf("."));
    	}
    	
	/*
	 * This method was fixed after Kris Barnhoorn (kurioskronic) submitted SF bug #991489
	 */
  	public static String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}	
	
}
