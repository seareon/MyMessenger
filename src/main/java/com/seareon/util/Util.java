package com.seareon.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	public static boolean isEMail(String str) {
		Pattern p = Pattern.compile(Constants.PATTERN_EMAIL);
		Matcher match = p.matcher(str);
		return match.matches();
	}
	
	public static boolean isLogin(String str) {
		Pattern pLog = Pattern.compile(Constants.PATTERN_LOGIN); 
		Matcher mLog = pLog.matcher(str);
		return mLog.matches();
	}
	
	public static boolean isPassword(String str) {
		Pattern pPass = Pattern.compile(Constants.PATTERN_PASSWORD);
		Matcher mPass = pPass.matcher(str);
		return mPass.matches();
	}
}
