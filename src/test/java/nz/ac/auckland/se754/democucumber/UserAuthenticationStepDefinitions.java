package nz.ac.auckland.se754.democucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAuthenticationStepDefinitions {

    String username, password, status;

    @Given("the students {string} and {string} are enrolled with passwords {string}")
    public void the_students_and_are_enrolled_with_passwords(String user1, String user2, String passwords) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I have entered username {string} into the login page")
    public void i_have_entered_username_into_the_login_page(String username) {
//        this.username = username;
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I have entered password {string} into the login page")
    public void i_have_entered_password_into_the_login_page(String password) {
//        this.password = password;
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I press login")
    public void i_press_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("My status in the system should be {string}")
    public void my_status_in_the_system_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
