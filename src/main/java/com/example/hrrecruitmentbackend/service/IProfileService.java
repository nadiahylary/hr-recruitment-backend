package com.example.hrrecruitmentbackend.service;

import com.example.hrrecruitmentbackend.model.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProfileService {
    public List<Profile> getAllProfiles();
    public List<Profile> getProfilesBySearchWordExp(String searchword);
    public List<Profile> getProfilesBySearchWordSkills(String searchword);
    public List<Profile> getProfilesBySearchWordLocation(String searchword);
    public List<Profile> getProfilesBySearchWordPosition(String searchword);
    public List<Profile> getProfilesBySearchWordDescription(String searchword);


    public List<Profile> getProfilesByCategory(String category);


}
