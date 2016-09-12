package com.seareon.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, Constants.EMAIL, Constants.EMAIL_HAS_A_INVALID_VALUE);
		
		ProfileDTO profileDTO = (ProfileDTO) arg0; 
		String email = profileDTO.getUser().getEmail();
		
		if(email != null) {
			if(!Util.isEMail(email)) {
				arg1.rejectValue(Constants.EMAIL, Constants.EMAIL_HAS_A_INVALID_VALUE);
			}
		} 
	}
}
