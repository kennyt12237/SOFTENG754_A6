package nz.ac.auckland.se754.democucumber;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LectureSystemDatabase {

    private Map<String, String> accounts;
    private Map<String, Course> courses;

    public LectureSystemDatabase() {
        accounts = new HashMap<>();
        courses = new HashMap<>();
    }

    public void addAccount(String upi, String password) {

        accounts.put(upi, password);
    }

    public boolean checkRegisteredAccount(String upi, String password) {

        if (accounts.get(upi) == null) {
            throw new NoSuchElementException("Account doesn't exist");
        }

        return accounts.get(upi).equals(password);
    }

    public void addCourse(String courseId, Course course) {
        courses.put(courseId, course);
    }

    public Course getCourse(String courseId) {

        if (courses.get(courseId) == null) {
            throw new NoSuchElementException("Course doesn't exist");
        }

        return courses.get(courseId);
    }
}
