package com.example.eatsy9.dto;

public class PredictionDto {

    private String age;
    private String gender;
    private String height;
    private String weightGoal;
    private String currentWeight;
    private String targetWeight;
    private String activityLevel;
    private String weightLossPace;
    private String weightGainPace;
    private String dailyCalorieGoal;

    public PredictionDto(String age, String gender, String height, String weightGoal, String currentWeight, String targetWeight, String activityLevel, String weightLossPace, String weightGainPace, String dailyCalorieGoal) {
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weightGoal = weightGoal;
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.activityLevel = activityLevel;
        this.weightLossPace = weightLossPace;
        this.weightGainPace = weightGainPace;
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(String weightGoal) {
        this.weightGoal = weightGoal;
    }

    public String getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(String currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(String targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getWeightLossPace() {
        return weightLossPace;
    }

    public void setWeightLossPace(String weightLossPace) {
        this.weightLossPace = weightLossPace;
    }

    public String getWeightGainPace() {
        return weightGainPace;
    }

    public void setWeightGainPace(String weightGainPace) {
        this.weightGainPace = weightGainPace;
    }

    public String getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public void setDailyCalorieGoal(String dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }
}
