package net.spotapps.tester.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;
import net.spotapps.tester.dao.UserImageRepository;
import net.spotapps.tester.dao.UserInterestRepository;
import net.spotapps.tester.dao.UserProfileRepository;
import net.spotapps.tester.model.UserImage;
import net.spotapps.tester.model.UserInterest;
import net.spotapps.tester.model.UserProfile;

@Service
@Profile("render & !default")
public class RenderDataPopulationService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserImageRepository userImageRepository;

    @Autowired
    private UserInterestRepository userInterestRepository;

    @PostConstruct
    public void initData() {
        initUserProfiles();
        initUserImages();
        initUserInterests();
    }

    @Transactional
    private void initUserProfiles() {
        if(userProfileRepository.count() == 0) {
            userProfileRepository.saveAllAndFlush(IntStream.range(0, 100).mapToObj(i -> new UserProfile()).toList());
        }
    }

    private void initUserImages() {
        if (userImageRepository.count() == 0) {
            List<UserProfile> userProfiles = userProfileRepository.findAll();
            List<UserImage> images = new ArrayList<>();
            for (UserProfile userProfile : userProfiles) {
                images.addAll(IntStream.range(0, 4)
                    .mapToObj(i -> new UserImage(i + ".png", userProfile))
                    .toList());
            }
            userImageRepository.saveAllAndFlush(images);
        }
    }

    private void initUserInterests() {
        if (userInterestRepository.count() == 0) {
            List<UserProfile> userProfiles = userProfileRepository.findAll();
            List<UserInterest> interests = new ArrayList<>();
            for (UserProfile userProfile : userProfiles) {
                interests.addAll(IntStream.range(0, new Random().nextInt(7))
                .mapToObj(i -> new UserInterest(RandomStringUtils.randomAlphabetic(8), userProfile))
                .toList());
            }
            userInterestRepository.saveAllAndFlush(interests);
        }
    }

}
