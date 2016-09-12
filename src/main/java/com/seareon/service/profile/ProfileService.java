package com.seareon.service.profile;

import java.util.Set;
import com.seareon.dto.ProfileDTO;
import com.seareon.model.Post;

public interface ProfileService {
	public long saveProfile(ProfileDTO profileDTO);
	public void deleteProfile(long id);
	public void updateProfile(ProfileDTO profileDTO);
	public ProfileDTO getProfileById(long id);
	public ProfileDTO getProfileByUserId(long id);
}
