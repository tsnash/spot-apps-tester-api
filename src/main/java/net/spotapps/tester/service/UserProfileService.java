package net.spotapps.tester.service;

import java.util.List;

import net.spotapps.tester.dto.UserProfileDto;

public interface UserProfileService {

    UserProfileDto getUserProfile(String userId);

    List<UserProfileDto> getUserProfileList(List<String> userIds);

    List<UserProfileDto> getAllProfiles();

}
