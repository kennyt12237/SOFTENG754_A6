package nz.ac.auckland.se754.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserGroup {

    private Boolean isBreakoutRoomsEnabled;
    private List<BreakoutRoom> breakoutRooms;
    private List<List<User>> preDefinedGroups;
    private List<User> userList;

    public UserGroup(ArrayList<User> list) {
        isBreakoutRoomsEnabled = false;
        userList = list;
        breakoutRooms = new ArrayList<>();
    }

    public List<List<User>> importUserGroupsFromCanvas(Canvas cv) {
        return cv.getUserList();
    }

    public boolean createBreakoutRooms(List<List<User>> UserGroups) {
        userList.clear();
        breakoutRooms.clear();
        for (List<User> subGroup : UserGroups) {
            breakoutRooms.add(new BreakoutRoom(subGroup));
        }
        return true;
    }

    public Boolean createBreakoutRooms(Integer numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            breakoutRooms.add(new BreakoutRoom());
        }
        return true;
    }

    public void setTopicNameForGivenRoom(String id, String topic) {
        for (BreakoutRoom br : breakoutRooms) {
            if (br.getId().equals(UUID.fromString(id))) {
                br.setTopicName(topic);
            }
        }
    }

    public User findUser(String userString) {
        User usr = userList.stream()
                .filter(user -> userString.equals(user.getUserName()))
                .findAny()
                .orElse(null);
        return usr;
    }

    public BreakoutRoom findBreakoutRoom(String id) {
        for (BreakoutRoom br : breakoutRooms) {
            if (br.getId().equals(UUID.fromString(id))) {
                return br;
            }
        }
        return null;
    }

    public Boolean getBreakoutRoomsEnabled() {
        return isBreakoutRoomsEnabled;
    }

    public void setBreakoutRoomsEnabled(Boolean breakoutRoomsEnabled) {
        isBreakoutRoomsEnabled = breakoutRoomsEnabled;
    }

    public List<BreakoutRoom> getBreakoutRooms() {
        return this.breakoutRooms;
    }

    public void setGroups(List<List<User>> groups) {
        preDefinedGroups = groups;
    }

    public List<List<User>> importUserGroups() {
        return preDefinedGroups;
    }

    public void setGroup(List<User> mainGroup) {
        userList = mainGroup;
    }

    public List<User> getStudents() {
        return userList;
    }

    public void joinBreakoutRoom(User user, BreakoutRoom room) {
        if (room.findUser(user)) {

        } else {
            if (userList.contains(user)) {
                if (room.AddNewUser(user)) {
                    userList.remove(user);
                }
            }
        }
    }

    public void sendBackToBreakoutRoom(BreakoutRoom room) {
        for (User user : room.getUserSubGroup()) {
            userList.add(user);
        }
        room.setUserSubGroup(new ArrayList<>());
    }
}
