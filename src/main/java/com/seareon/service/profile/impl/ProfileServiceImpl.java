package com.seareon.service.profile.impl;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.seareon.dto.ProfileDTO;
import com.seareon.model.Post;
import com.seareon.model.Profile;
import com.seareon.service.profile.ProfileService;
import com.seareon.converter.profile.ProfileDTOProfile;
import com.seareon.dao.profile.ProfileDAO;;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
	@Autowired
    private ProfileDAO profileDAO;
	
	public long saveProfile(ProfileDTO profileDTO) {
		// TODO Auto-generated method stub
		Profile profile = ProfileDTOProfile.ProfileDTOToProfileConvert(profileDTO);
		return profileDAO.saveProfile(profile);
	}

	public void deleteProfile(long id) {
		// TODO Auto-generated method stub
		profileDAO.deleteProfile(id);
	}

	public void updateProfile(ProfileDTO profileDTO) {
		// TODO Auto-generated method stub
		Profile profile = ProfileDTOProfile.ProfileDTOToProfileConvert(profileDTO);
		profileDAO.updateProfile(profile);
}

	public ProfileDTO getProfileById(long id) {
		// TODO Auto-generated method stub
		return ProfileDTOProfile.ProfileToProfileDTOConvert(profileDAO.getProfile(id));
	}

	public ProfileDTO getProfileByUserId(long id) {
		// TODO Auto-generated method stub
		return ProfileDTOProfile.ProfileToProfileDTOConvert(profileDAO.getProfileByUserId(id));
	}
}
