package com.seareon.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.seareon.dto.ProfileDTO;
import com.seareon.util.Constants;
import com.seareon.util.Util;

@Component
public class ProfileDTOValidator implements Validator {
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ProfileDTO.class.isAssignableFrom(arg0);
	}
	
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub		
		ProfileDTO profileDTO = (ProfileDTO) arg0; 
		String email = profileDTO.getUser().getEmail();
		
		if(email != null) {
			if(!Util.isEMail(email)) {
				arg1.rejectValue(Constants.EMAIL, Constants.EMAIL_HAS_A_INVALID_VALUE);	// чёт бросает exception
			}
		} 
		
		String login = profileDTO.getUser().getLogin();
		
		if(!Util.isLogin(login)) {
			arg1.rejectValue(Constants.USER_LOGIN, Constants.LOGIN_IS_NOT_BY_A_REGULAR_EXPRESSION);
		}
		
		String password = profileDTO.getUser().getPassword();
		
		if(!Util.isPassword(password)) {
			arg1.rejectValue(Constants.USER_PASSWORD, Constants.PASSWORD_IS_NOT_BY_A_REGULAR_EXPRESSION);
		}
	}
}
