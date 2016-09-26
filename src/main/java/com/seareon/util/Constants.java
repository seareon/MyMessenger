package com.seareon.util;

public class Constants {
	public static final String QUERY_GET_USER_BY_LOGIN = "FROM com.seareon.model.User U WHERE U.login = :login";
	public static final String QUERY_GET_USER_BY_ID = "FROM com.seareon.model.User U WHERE U.id = :id";
	public static final String PATTERN_EMAIL = "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^" + 
			"_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*" + 
			"(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name" + 
			"|net|org|pro|tel|travel|[a-z][a-z])$";
	public static final String PATTERN_LOGIN = "^[\\w.-@]{6,20}$";
	public static final String PATTERN_PASSWORD = "^[\\w]{6,8}$";
	public static final String LOGIN = "login";
	public static final String USER_LOGIN = "user.login";
	public static final String LOGIN_IS_EMPTY = "label.loginEmpty";
	public static final String PASSWORD = "password";
	public static final String USER_PASSWORD = "user.password";	
	public static final String PASSWORD_IS_EMPTY = "label.passwordEmpty";
	public static final String LOGIN_IS_NOT_BY_A_REGULAR_EXPRESSION = "label.login.notReg";
	public static final String PASSWORD_IS_NOT_BY_A_REGULAR_EXPRESSION = "label.password.notReg";
	public static final String EMAIL = "user.email";
	public static final String EMAIL_HAS_A_INVALID_VALUE = "label.EmailHasInvalidValue";
	public static final String QUERY_GET_PROFILE_BY_USER_ID = 
			"FROM  com.seareon.model.Profile P WHERE P.user.id = :id";
	public static final String QUERY_GET_PROFILE_BY_USER_LOGIN = 
			"FROM  com.seareon.model.Profile P WHERE P.user.login = :login";
}
