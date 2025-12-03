package net.spotapps.tester.service;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import net.spotapps.tester.UserProfileConstants;
import net.spotapps.tester.dao.UserProfileRepository;
import net.spotapps.tester.dto.UserProfileDto;
import net.spotapps.tester.model.UserProfile;
import net.spotapps.tester.model.exception.InvalidUserIdException;
import net.spotapps.tester.model.exception.UserProfileNotFoundException;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(final UserProfileRepository repository) {

        this.userProfileRepository = repository;
    }

    @Override
    public UserProfileDto getUserProfile(final String userId) {

        validateId(userId);

        Long id = NumberUtils.createLong(userId);

        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(
                () -> new UserProfileNotFoundException(UserProfileConstants.USER_PROFILE_NOT_FOUND_MESSAGE, id));

        return UserProfileDto.convertUserProfileToDto(userProfile);
    }

    @Override
    public List<UserProfileDto> getUserProfileList(final List<String> userIds) {

        List<Long> validUserIds = userIds.stream()
                .filter(NumberUtils::isDigits)
                .map(NumberUtils::createLong)
                .toList();

        if (validUserIds.isEmpty()) {
            return Collections.emptyList();
        }

        return userProfileRepository.findAllByUserIdInOrderByUserIdAsc(validUserIds).stream()
                .map(UserProfileDto::convertUserProfileToDto)
                .toList();
    }

    @Override
    public List<UserProfileDto> getAllProfiles() {

        return userProfileRepository.findAll().stream()
                .map(UserProfileDto::convertUserProfileToDto)
                .toList();
    }

    private void validateId(final String userId) {

        if (!NumberUtils.isDigits(userId)) {
            throw new InvalidUserIdException(UserProfileConstants.INVALID_ID_MESSAGE, userId);
        }
    }

}
