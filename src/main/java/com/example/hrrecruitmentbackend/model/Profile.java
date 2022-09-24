package com.example.hrrecruitmentbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "profiles")
public class Profile {
    @Id
    @Field(name = "_id")
    private ObjectId id;

    @Field(name = "index")
    private String index;

    @Field(name = "category")
    private String category;

    @Field(name = "linkedin")
    private String profile_url;

    @Field(name = "profile_picture")
    private String imgUrl;

    @Field(name = "description")
    private String description;

    @Field(name = "Experience")
    private String experience;

    @Field(name = "Name")
    private String name;

    @Field(name = "position")
    private String position;

    @Field(name = "location")
    private String location;

    @Field(name = "skills")
    private String[] skills;

    @Field(name = "clean_skills")
    private String[] clean_skills;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String[] getClean_skills() {
        return clean_skills;
    }

    public void setClean_skills(String[] clean_skills) {
        this.clean_skills = clean_skills;
    }

}
