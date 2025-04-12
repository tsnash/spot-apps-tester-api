package net.spotapps.tester.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spotapps.tester.UserProfileConstants;
import net.spotapps.tester.dao.UserProfileRepository;
import net.spotapps.tester.model.UserProfile;
import net.spotapps.tester.model.exception.InvalidIdException;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private UserProfileRepository userProfileRepository;
    
    @Autowired
    public UserProfileServiceImpl(final UserProfileRepository repository) {

        this.userProfileRepository = repository;
    }

    @Override
    public UserProfile getUserProfile(final String userId) {

        validateId(userId);

        Long id = NumberUtils.createLong(userId);

        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(id);

        return optionalUserProfile.orElse(null);
    }

    @Override
    public List<UserProfile> getUserProfileList(final List<String> userIds) {
        
        List<Long> validUserIds = userIds.stream()
            .filter(NumberUtils::isDigits)
            .map(NumberUtils::createLong)
            .toList();

        if (validUserIds.isEmpty()) {
            return Collections.emptyList();
        }

        return userProfileRepository.findAllByUserIdInOrderByUserIdAsc(validUserIds);
    }

    @Override
    public List<UserProfile> getAllProfiles() {
        
        return userProfileRepository.findAll();
    }

    private void validateId(final String userId) {

        if (!NumberUtils.isDigits(userId)) {
            throw new InvalidIdException(UserProfileConstants.INVALID_ID_MESSAGE, userId);
        }
    }

}
