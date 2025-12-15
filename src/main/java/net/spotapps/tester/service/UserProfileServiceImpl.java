package net.spotapps.tester.service;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import net.spotapps.tester.UserProfileConstants;
import net.spotapps.tester.dao.UserProfileRepository;
import net.spotapps.tester.dto.UserProfileDto;
import net.spotapps.tester.model.UserProfile;
import net.spotapps.tester.model.exception.InvalidUserIdCollectionException;
import net.spotapps.tester.model.exception.InvalidUserIdException;
import net.spotapps.tester.model.exception.UserProfileCollectionNotFoundException;
import net.spotapps.tester.model.exception.UserProfileNotFoundException;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(final UserProfileRepository repository) {

        this.userProfileRepository = repository;
    }

    @Override
    public UserProfileDto getUserProfile(final String userId) {

        if (!isValidUserId(userId)) {
            throw new InvalidUserIdException(UserProfileConstants.INVALID_ID_MESSAGE, userId);
        }

        Long id = NumberUtils.createLong(userId);

        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(
                () -> new UserProfileNotFoundException(UserProfileConstants.USER_PROFILE_NOT_FOUND_MESSAGE, id));

        return UserProfileDto.convertUserProfileToDto(userProfile);
    }

    @Override
    public List<UserProfileDto> getUserProfileList(final List<String> userIds) {

        var invalidUserIds = getInvalidUserIds(userIds);

        if (!invalidUserIds.isEmpty()) {
            throw new InvalidUserIdCollectionException(
                    UserProfileConstants.INVALID_ID_COLLECTION_MESSAGE, invalidUserIds);
        }

        var userProfiles = userProfileRepository.findAllByUserIdInOrderByUserIdAsc(userIds.stream()
                .map(NumberUtils::createLong)
                .toList());

        if (userProfiles.isEmpty()) {
            throw new UserProfileCollectionNotFoundException(
                    UserProfileConstants.USER_PROFILE_NOT_FOUND_MESSAGE, userIds);
        }

        return userProfiles.stream()
                .map(UserProfileDto::convertUserProfileToDto)
                .toList();
    }

    @Override
    public List<UserProfileDto> getAllProfiles() {

        return userProfileRepository.findAll().stream()
                .map(UserProfileDto::convertUserProfileToDto)
                .toList();
    }

    private boolean isValidUserId(final String userId) {
        if (userId == null || !NumberUtils.isDigits(userId)) {
            return false;
        }
        try {
            Long.parseLong(userId);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private List<String> getInvalidUserIds(final List<String> userIds) {
        return userIds.stream()
                .filter(userId -> !isValidUserId(userId))
                .toList();
    }

}
