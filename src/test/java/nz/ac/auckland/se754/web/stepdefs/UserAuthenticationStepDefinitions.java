package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.service.LectureSystem;
import nz.ac.auckland.se754.web.pages.UserAuthenticationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class UserAuthenticationStepDefinitions {

    private LectureSystem lectureSystem;
    private String username;

    private WebDriver driver;
    private UserAuthenticationPage userAuthenticationPage;

    @Before
    public void setup() {
        //need to change win to macos when pushing and remove .exe
        System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");

        //System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        userAuthenticationPage = new UserAuthenticationPage(driver);
    }

    @AfterStep
    public void afterEachStep() {
        // to make the test at human speed
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("the students {string} and {string} are enrolled with passwords {string}")
    public void the_students_and_are_enrolled_with_passwords(String username1, String username2, String passwords) {
        lectureSystem = new LectureSystem(Arrays.asList(username1, username2), Arrays.asList(passwords, passwords), new ArrayList<>());
    }

    @Given("I visit {string}")
    public void i_visit(String string) {
        driver.get("http://localhost:8080" + string);
    }

    /* Specific to scenario Successfully logging into the lecture system. */

    @Given("I have entered username {string} into the username field")
    public void i_have_entered_username_into_the_username_field(String username) {
        this.username = username;
        userAuthenticationPage.insertUserName(username);
    }

    @Given("I have entered password {string} into the password field")
    public void i_have_entered_password_into_the_password_field(String password) {
        userAuthenticationPage.insertPassword(password);
    }

    @When("I press the login button")
    public void i_press_login_button() {
        userAuthenticationPage.clickLogin();
    }

    @Then("I should see the welcome page")
    public void i_should_see_the_welcome_page() {
        assertEquals(userAuthenticationPage.getMessage(), "Welcome " + username + "!");
    }

    /* Specific to scenario Logging into the lecture system using SSO. */

    @When("I press the Sign in with SSO button")
    public void i_press_the_sign_in_with_sso_button() {
        userAuthenticationPage.clickSso();
    }

    @Then("I should see the SSO login page")
    public void i_should_see_the_sso_login_page() {
        assertEquals(userAuthenticationPage.getMessage(), "Welcome SSO User!");
        assertEquals(userAuthenticationPage.getWelcomeText(), "Thank you for signing in through SSO");
    }

    /* Specific to scenario Unsuccessfully logging into the lecture system. */
    @Then("I should not see the welcome page")
    public void i_should_not_see_the_welcome_page() {
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/login");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        assertEquals(userAuthenticationPage.getErrorMessage(), "Invalid Credentials");
    }

    @Then("I can redirect to the welcome page")
    public void i_can_redirect_to_the_welcome_page() {
        userAuthenticationPage.clickRedirectButton();
        assertEquals(userAuthenticationPage.getMessage(), "Welcome SSO User!");
    }

    /* User story 104 */

    /* Successfully entering a lecture */

    @Given("I am authenticated")
    public void i_am_authenticated() {
        userAuthenticationPage.becomeAuthenticated();
    }

    @Given("I am enrolled in the course")
    public void i_am_enrolled_in_the_course() {
        userAuthenticationPage.becomeEnrolled();
    }

    @When("I press the Join Lecture button")
    public void i_press_the_join_lecture_button() {
        userAuthenticationPage.clickJoinLectureButton();
    }

    @Then("I should be redirected to the lecture")
    public void i_should_be_redirected_to_the_lecture() {
        assertEquals(userAuthenticationPage.getLectureWelcomeText(), "Welcome to SOFTENG 754");
    }

    /* Unsuccessfully joining a lecture */

    @Given("My authentication status is {string}")
    public void my_authentication_status_is(String string) {
        boolean authenticated = Boolean.parseBoolean(string);

        if (authenticated) {
            this.userAuthenticationPage.becomeAuthenticated();
        }
    }

    @Given("My enrolment status is {string}")
    public void my_enrolment_status_is(String string) {
        boolean enrolled = Boolean.parseBoolean(string);

        if (enrolled) {
            this.userAuthenticationPage.becomeEnrolled();
        }
    }

    @Then("I should not be redirected to the lecture")
    public void i_should_not_be_redirected_to_the_lecture() {
        assertEquals(userAuthenticationPage.getLectureName(), "SOFTENG 754");
        assertEquals(userAuthenticationPage.getErrorMessage(), "Invalid Credentials");
    }

}
