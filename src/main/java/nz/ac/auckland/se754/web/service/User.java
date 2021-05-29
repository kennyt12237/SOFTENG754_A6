package nz.ac.auckland.se754.web.service;

public class User {
    public String userName;

    public String getDesignation() {
        return designation;
    }

    private String designation;

    public User(String name){
        userName = name;
    }

    public String getUserName() {
        return userName;
    }
}
