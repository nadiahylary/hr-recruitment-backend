package com.example.hrrecruitmentbackend.service;

import com.example.hrrecruitmentbackend.dao.ProfileRepository;
import com.example.hrrecruitmentbackend.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements IProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public List<Profile> getProfilesBySearchWordExp(String searchword) {
        return profileRepository.findAllByExperienceLikeIgnoreCase(searchword);

    }

    @Override
    public List<Profile> getProfilesByCategory(String category) {

        return profileRepository.findProfilesByCategoryIgnoreCase(category);
    }

    @Override
    public List<Profile> getProfilesBySearchWordSkills(String searchword) {
        return profileRepository.findProfilesBySkillsLikeIgnoreCase(searchword);
    }

    @Override
    public List<Profile> getProfilesBySearchWordLocation(String searchword) {
        return profileRepository.findProfilesByLocationLikeIgnoreCase(searchword);
    }

    @Override
    public List<Profile> getProfilesBySearchWordPosition(String searchword) {
        return profileRepository.findProfilesByPositionLikeIgnoreCase(searchword);
    }

    @Override
    public List<Profile> getProfilesBySearchWordDescription(String searchword) {
        return profileRepository.findProfilesByDescriptionLikeIgnoreCase(searchword);
    }
}
