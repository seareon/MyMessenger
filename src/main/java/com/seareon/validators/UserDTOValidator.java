package com.seareon.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.seareon.util.Util;
import com.seareon.dto.UserDTO;
import com.seareon.util.Constants;

@Component
public class UserDTOValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return false;
    }
	
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
/*		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, Constants.LOGIN, Constants.LOGIN_IS_EMPTY);
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, Constants.PASSWORD, Constants.PASSWORD_IS_EMPTY); */
		
		UserDTO userDTO = (UserDTO)arg0;
		String log = userDTO.getLogin();
		
		checkLogin(log, arg1);
		
/*		if(!Util.isLogin(log)) {
			arg1.rejectValue(Constants.LOGIN, Constants.LOGIN_IS_NOT_BY_A_REGULAR_EXPRESSION);
		} */
		
		String pass = userDTO.getPassword();
		
		checkPassword(pass, arg1);
		
	/*	if(!Util.isPassword(pass)) {
			arg1.rejectValue(Constants.PASSWORD, Constants.PASSWORD_IS_NOT_BY_A_REGULAR_EXPRESSION);
		} */
	}
	
	static void checkLogin(String login, Errors errors) {
		if(!Util.isLogin(login)) {
			errors.rejectValue(Constants.LOGIN, Constants.LOGIN_IS_NOT_BY_A_REGULAR_EXPRESSION);
		}
	}
	
	static void checkPassword(String password, Errors errors) {
		if(!Util.isPassword(password)) {
			errors.rejectValue(Constants.PASSWORD, Constants.PASSWORD_IS_NOT_BY_A_REGULAR_EXPRESSION);
		}
	}
}
