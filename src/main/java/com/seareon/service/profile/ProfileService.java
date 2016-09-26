package com.seareon.service.profile;

import com.seareon.dto.ProfileDTO;
import com.seareon.model.Profile;

public interface ProfileService {
	public long saveProfile(Profile profile);
	public void updateProfile(Profile profileDTO);
	public ProfileDTO getProfileDTOById(long id);
	public Profile getProfileById(long id);
	public ProfileDTO getProfileDTOByUserId(long id);
	public ProfileDTO getProfileDTOByUserLogin(String userLogin); 
}
