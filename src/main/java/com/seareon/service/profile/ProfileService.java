package com.seareon.service.profile;

import java.util.Set;
import com.seareon.dto.ProfileDTO;
import com.seareon.model.Post;
import com.seareon.model.Profile;

public interface ProfileService {
	public long saveProfile(Profile profile);
	public void deleteProfile(long id);
	public void updateProfile(ProfileDTO profileDTO);
	public ProfileDTO getProfileDTOById(long id);
	public Profile getProfileById(long id);
	public Profile getProfileByUserId(long id);
	public ProfileDTO getProfileDTOByUserId(long id);
	public ProfileDTO getProfileDTOByUserLogin(String userLogin); 
}
