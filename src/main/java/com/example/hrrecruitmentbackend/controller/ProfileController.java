package com.example.hrrecruitmentbackend.controller;

import com.example.hrrecruitmentbackend.model.Profile;
import com.example.hrrecruitmentbackend.service.IProfileService;
import com.example.hrrecruitmentbackend.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    IProfileService profileService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Profile>> getAllProfiles () {
        List<Profile> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Profile>> getProfilesByExperience (@PathVariable("searchword") String str) {
        List<Profile> profiles = profileService.getProfilesBySearchWordExp(str);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Profile>> getProfilesByLocation (String str) {
        List<Profile> profiles = profileService.getProfilesBySearchWordLocation(str);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    @RequestMapping(value = "{category}{searchword}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Profile>> getProfilesBySkills (@PathVariable("skills") String str) {
        List<Profile> profiles = profileService.getProfilesBySearchWordSkills(str);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    @RequestMapping(value = "{category}{searchword}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Profile>> getProfilesByPosition(@PathVariable("position") String str) {
        List<Profile> profiles = profileService.getProfilesBySearchWordPosition(str);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    @RequestMapping(value = "{category}{searchword}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Profile>> getProfilesByAbout (String str) {
        List<Profile> profiles = profileService.getProfilesBySearchWordDescription(str);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @RequestMapping(value = "/{category}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Profile>> getProfilesByCategory (@PathVariable("category") String cat) {
        List<Profile> profiles = profileService.getProfilesByCategory(cat);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @RequestMapping(value = "{category}{searchword}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Profile>> getProfilesByCategoryAndSearchW(@PathVariable("category") String category,
                                                                         @PathVariable("searchword") String searchword) {
        Predicate<Profile> list = (Predicate<Profile>) profileService.getProfilesByCategory(category);
        List<Profile> profiles = profileService.getProfilesBySearchWordExp(searchword).stream().filter(list).toList();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
}
