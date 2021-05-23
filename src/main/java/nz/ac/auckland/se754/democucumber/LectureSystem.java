package nz.ac.auckland.se754.democucumber;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.NoSuchElementException;

public class LectureSystem {

    private LectureSystemDatabase lectureSystemDatabase;

    public LectureSystem() {
        lectureSystemDatabase = new LectureSystemDatabase();
    }

    public LectureSystem(List<String> upis, List<String> passwords, List<Course> courses) {

        this();

        for (int i = 0; i < upis.size(); i++) {
            lectureSystemDatabase.addAccount(upis.get(i), passwords.get(i));
        }

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            lectureSystemDatabase.addCourse(course.getCourseName(), course);
        }
    }

    public boolean login(String upi, String password) throws NoSuchElementException {

        if (password.isEmpty() || upi.isEmpty()) {
            return false;
        }

        return lectureSystemDatabase.checkRegisteredAccount(upi, password);
    }

    public boolean enrolledInCourse(String courseId, String upi) {

        // get the course
        Course course = lectureSystemDatabase.getCourse(courseId);

        return course.studentEnrolledInCourse(upi);
    }

    public boolean joinLecture(String upi, String password, String courseId) {

        // login
        login(upi, password);
        boolean enrolled = enrolledInCourse(courseId, upi);

        if (!enrolled) {
            throw new NoSuchElementException("User is not enrolled");
        }

        return true;
    }
}
