package nz.ac.auckland.se754.web.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class Login {

    private ArrayList<String> usernames = new ArrayList<>(Arrays.asList("cpat430", "akha379", "cpat430@aucklanduni.ac.nz"));
    private ArrayList<String> passwords = new ArrayList<>(Arrays.asList("myPassword1", "myPassword1", "myPassword1"));
    private ArrayList<Course> courses = new ArrayList<>();
    private LectureSystem lectureSystem = new LectureSystem(usernames, passwords, courses);

    public boolean validateUser(String userid, String password) {

        return lectureSystem.login(userid, password);
    }

}