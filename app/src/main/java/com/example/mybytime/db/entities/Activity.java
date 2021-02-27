package com.example.mybytime.db.entities;

import java.util.Date;

public class Activity {
    private long id;
    private String name;
    private String description;
    private double averageCheck;
    private PartyType partyType;
    private Gender preferredGender;
    private ActivityType activityType;
    private double lat;
    private double lng;
    private Date startDateTime;
    private Date endDateTime;

    public Activity(long id, String name, String description, double averageCheck, PartyType partyType, Gender preferredGender, ActivityType activityType, double lat, double lng, Date startDateTime, Date endDateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.averageCheck = averageCheck;
        this.partyType = partyType;
        this.preferredGender = preferredGender;
        this.activityType = activityType;
        this.lat = lat;
        this.lng = lng;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAverageCheck() {
        return averageCheck;
    }

    public void setAverageCheck(double averageCheck) {
        this.averageCheck = averageCheck;
    }

    public PartyType getPartyType() {
        return partyType;
    }

    public void setPartyType(PartyType partyType) {
        this.partyType = partyType;
    }

    public Gender getPreferredGender() {
        return preferredGender;
    }

    public void setPreferredGender(Gender preferredGender) {
        this.preferredGender = preferredGender;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }
}
