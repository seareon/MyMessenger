package com.seareon.dao.profile;

import com.seareon.model.Profile;

public interface ProfileDAO {
	long saveProfile(Profile profile);
    void deleteProfile(long id);
    void updateProfile(Profile profile);
    Profile getProfile(long id);
    Profile getProfileByUserId(long id);
}
