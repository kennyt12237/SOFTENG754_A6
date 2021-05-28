package nz.ac.auckland.se754.web.service;

import java.util.ArrayList;
import java.util.List;

public class BreakoutRoom {

    private String topicName;
    private Integer maxGroupSize = 10;
    private List<User> userSubGroup;
    private Boolean ActivityStatus;

    //Create Breakout Room
    public BreakoutRoom() {
        userSubGroup = new ArrayList<User>();
        ActivityStatus = false;
    }

    //Create Breakout Room with a group of students
    public BreakoutRoom(List<User> group) {
        userSubGroup = group;
    }

    //Set Breakout Room Topic Name
    public void SetTopicName(String topic) {
        this.topicName = topic;
    }

    //Get Breakout Room Topic Name
    public String GetTopicName() {
        return this.topicName;
    }

    public List<User> GetUserGroup() {
        return userSubGroup;
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
        return ActivityStatus;
    }

    public void NotifyActivityComplete() {
        ActivityStatus = true;
    }

}
