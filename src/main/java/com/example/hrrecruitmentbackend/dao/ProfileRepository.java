package com.example.hrrecruitmentbackend.dao;

import com.example.hrrecruitmentbackend.model.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, ObjectId> {
    @Query("{ 'experience' : ?0 }")
    List<Profile> findAllByExperienceLikeIgnoreCase(String experience);
    @Query("{ 'category' : ?0 }")
    List<Profile> findProfilesByCategoryIgnoreCase(String category);
    @Query("{ 'position' : ?0 }")
    List<Profile> findProfilesByPositionLikeIgnoreCase(String position);
    @Query("{ 'skills' : ?0 }")
    List<Profile> findProfilesBySkillsLikeIgnoreCase(String skills);
    @Query("{ 'description' : ?0 }")
    List<Profile> findProfilesByDescriptionLikeIgnoreCase(String description);
    @Query("{ 'location' : ?0 }")
    List<Profile> findProfilesByLocationLikeIgnoreCase(String location);

    @Override
    List<Profile> findAll();
}
