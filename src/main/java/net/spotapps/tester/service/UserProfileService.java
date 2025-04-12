package net.spotapps.tester.service;

import java.util.List;

import net.spotapps.tester.model.UserProfile;

public interface UserProfileService {

    UserProfile getUserProfile(String userId);

    List<UserProfile> getUserProfileList(List<String> userIds);

    List<UserProfile> getAllProfiles();
    
}
