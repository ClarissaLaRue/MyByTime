package com.example.mybytime.db.entities;

import java.util.Date;

public class Person {
    private int id;
    private int age;
    private Gender gender;
    private Date startDateTime;
    private Date endDateTime;
    private ActivityType activityType;
    private double amount;
    private PartyType partyType;

    public Person(int id, int age, Gender gender, Date startDateTime, Date endDateTime, ActivityType activityType, double amount, PartyType partyType) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.activityType = activityType;
        this.amount = amount;
        this.partyType = partyType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PartyType getPartyType() {
        return partyType;
    }

    public void setPartyType(PartyType partyType) {
        this.partyType = partyType;
    }
}
