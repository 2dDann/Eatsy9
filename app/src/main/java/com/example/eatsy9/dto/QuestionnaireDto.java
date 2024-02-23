package com.example.eatsy9.dto;

public class QuestionnaireDto {

    private Integer customerId;
    private Integer age;
    private String gender;
    private Integer height;
    private String weightGoal;
    private Integer currentWeight;
    private Integer targetWeight;
    private String activityLevel;
    private String weightLossPace;
    private String weightGainPace;
    private Integer dailyCalorieGoal;

    public QuestionnaireDto(Integer customerId, Integer age, String gender, Integer height, String weightGoal, Integer currentWeight, Integer targetWeight, String activityLevel, String weightLossPace, String weightGainPace, Integer dailyCalorieGoal) {
        this.customerId = customerId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(String weightGoal) {
        this.weightGoal = weightGoal;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Integer getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Integer targetWeight) {
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

    public Integer getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public void setDailyCalorieGoal(Integer dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }
}
