package com.seareon.converter.profile;

import com.seareon.dto.ProfileDTO;
import com.seareon.model.Profile;

public class ProfileDTOProfile {
	public static Profile ProfileDTOToProfileConvert(ProfileDTO profileDTO) {
		Profile profile = new Profile();
		profile.setAge(profileDTO.getAge());
		profile.setCity(profileDTO.getCity());
		profile.setCountry(profileDTO.getCountry());
		profile.setFirstName(profileDTO.getFirstName());
		profile.setGender(profileDTO.getGender());
		profile.setLastName(profileDTO.getLastName());
		profile.setUser(profileDTO.getUser());
		return profile;
	}
	
	public static ProfileDTO ProfileToProfileDTOConvert(Profile profile) {
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setAge(profile.getAge());
		profileDTO.setCity(profileDTO.getCity());
		profileDTO.setCountry(profile.getCountry());
		profileDTO.setFirstName(profile.getFirstName());
		profileDTO.setGender(profile.getGender());
		profileDTO.setLastName(profile.getLastName());
		profileDTO.setUser(profile.getUser());
		return profileDTO;
	}
}
