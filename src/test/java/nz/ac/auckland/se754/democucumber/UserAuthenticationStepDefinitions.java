package nz.ac.auckland.se754.democucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAuthenticationStepDefinitions {

    LectureSystem lectureSystem;
    String username, password, status;

    @Given("the students {string} and {string} are enrolled with passwords {string}")
    public void the_students_and_are_enrolled_with_passwords(String user1, String user2, String passwords) {

        lectureSystem = new LectureSystem(Arrays.asList(user1, user2), Arrays.asList(passwords, passwords), new ArrayList<Course>());
    }

    @Given("I have entered username {string} into the login page")
    public void i_have_entered_username_into_the_login_page(String username) {
        this.username = username;
    }

    @Given("I have entered password {string} into the login page")
    public void i_have_entered_password_into_the_login_page(String password) {
        this.password = password;
    }

    @When("I press login")
    public void i_press_login() {
        status = String.valueOf(lectureSystem.login(username, password));
    }

    @Then("My status in the system should be {string}")
    public void my_status_in_the_system_should_be(String expected) {
        assertEquals(expected, status);
    }
}
