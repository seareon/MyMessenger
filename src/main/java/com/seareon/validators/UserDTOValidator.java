package com.seareon.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.seareon.util.Util;
import com.seareon.dto.UserDTO;
import com.seareon.model.User;
import com.seareon.util.Constants;

@Component
public class UserDTOValidator implements Validator {
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return UserDTO.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, Constants.LOGIN, Constants.LOGIN_IS_EMPTY);
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, Constants.PASSWORD, Constants.PASSWORD_IS_EMPTY);
		
		UserDTO userDTO = (UserDTO)arg0;
		String log = userDTO.getLogin();
		
		if(!Util.isLogin(log)) {
			arg1.rejectValue(Constants.LOGIN, Constants.LOGIN_IS_NOT_BY_A_REGULAR_EXPRESSION);
		}
		
		String pass = userDTO.getPassword();
		
		if(!Util.isPassword(pass)) {
			arg1.rejectValue(Constants.PASSWORD, Constants.PASSWORD_IS_NOT_BY_A_REGULAR_EXPRESSION);
		}
		
/*		String email = user.getEmail();
		
		if(email != null) {
			if(!Util.isEMail(email)) {
				arg1.rejectValue(Constants.EMAIL, Constants.EMAIL_HAS_A_INVALID_VALUE);
			}
		} */
	}

}
