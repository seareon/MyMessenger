package com.seareon.service.profile.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.seareon.dto.ProfileDTO;
import com.seareon.model.Profile;
import com.seareon.service.profile.ProfileService;
import com.seareon.converter.profile.ProfileDTOProfile;
import com.seareon.dao.profile.ProfileDAO;;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
	@Autowired
    private ProfileDAO profileDAO;
	
	public long saveProfile(Profile profile) {
		// TODO Auto-generated method stub
		long id = profileDAO.saveProfile(profile);
		return id;//profileDAO.saveProfile(profile);
	}

	public void deleteProfile(long id) {
		// TODO Auto-generated method stub
		profileDAO.deleteProfile(id);
	}

	public void updateProfile(Profile profileDTO) {
		// TODO Auto-generated method stub
//		Profile profile = ProfileDTOProfile.ProfileDTOToProfileConvert(profileDTO);
		profileDAO.updateProfile(profileDTO);
}

	public ProfileDTO getProfileDTOById(long id) {
		// TODO Auto-generated method stub
		return ProfileDTOProfile.ProfileToProfileDTOConvert(profileDAO.getProfile(id));
	}
	public Profile getProfileById(long id) {
		return profileDAO.getProfile(id);
	}

	public ProfileDTO getProfileDTOByUserId(long id) {
		// TODO Auto-generated method stub
		return ProfileDTOProfile.ProfileToProfileDTOConvert(profileDAO.getProfileByUserId(id));
	}

	public ProfileDTO getProfileDTOByUserLogin(String userLogin) {		// ынести в отдельный класс логику
		// TODO Auto-generated method stub
		Profile profile = profileDAO.getProfileByUserLogin(userLogin);
		ProfileDTO profileDTO = null;
		if(profile != null) {
			profileDTO = ProfileDTOProfile.ProfileToProfileDTOConvert(profile);
		}
		return profileDTO;
	}

	public Profile getProfileByUserId(long id) {
		// TODO Auto-generated method stub
		return profileDAO.getProfileByUserId(id);
	}
}
