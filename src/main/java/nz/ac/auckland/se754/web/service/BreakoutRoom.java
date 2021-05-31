package nz.ac.auckland.se754.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BreakoutRoom {

    private UUID id;
    private String topicName;
    private Integer maxGroupSize = 10;
    private List<User> userSubGroup;

    private Boolean activityStatus;

    public Boolean getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public UUID getId() {
        return id;
    }

    public List<User> getUserSubGroup() {
        return userSubGroup;
    }

    //Create Breakout Room
    public BreakoutRoom() {
        topicName = "---";
        id = UUID.randomUUID();
        userSubGroup = new ArrayList<User>();
        activityStatus = false;
    }

    //Create Breakout Room with a group of students
    public BreakoutRoom(List<User> group) {
        topicName = "---";
        id = UUID.randomUUID();
        userSubGroup = group;
        activityStatus = false;
    }

    //Set Breakout Room Topic Name
    public void SetTopicName(String topic) {
        this.topicName = topic;
    }

    //Get Breakout Room Topic Name
    public String getTopicName() {
        return topicName;
    }

    public List<User> GetUserGroup() {
        return userSubGroup;
    }

    public Boolean findUser(User user) {
        if (userSubGroup.contains(user)) {
            return true;
        } else {
            return false;
        }
    }

    //Add a new user to the break out room
    public Boolean AddNewUser(User student) {
        if (userSubGroup.size() < maxGroupSize) {
            userSubGroup.add(student);
            return true;
        } else {
            return false;
        }
    }

    //Get  Number of participants in a breakout room
    public Integer GetNumberOfParticipants() {
        return this.userSubGroup.size();
    }

    //Set maximum number of participants in a Break out room
    public void SetMaxParticipants(Integer max) {
        maxGroupSize = max;
    }

    public boolean GetStatus() {
        return activityStatus;
    }

    public void NotifyActivityComplete() {
        activityStatus = true;
    }

}
