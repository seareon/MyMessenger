package com.seareon.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.seareon.util.Constants;
import com.seareon.util.Util;
import com.seareon.dto.UserDTO;

@Component
public class UserDTOValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return false;
    }
	
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub		
		UserDTO userDTO = (UserDTO)arg0;
		String log = userDTO.getLogin();
		
		if(!Util.isLogin(log)) {
			arg1.rejectValue(Constants.LOGIN, Constants.LOGIN_IS_NOT_BY_A_REGULAR_EXPRESSION);
		}
		
		String pass = userDTO.getPassword();
		
		if(!Util.isPassword(pass)) {
			arg1.rejectValue(Constants.PASSWORD, Constants.PASSWORD_IS_NOT_BY_A_REGULAR_EXPRESSION);
		}
	}
}
