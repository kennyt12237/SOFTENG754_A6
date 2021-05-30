package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.AuthenticationSystemPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticationSystemStepDefinitions {

    private WebDriver driver;
    private AuthenticationSystemPage authenticationSystemPage;

    @Before("@AuthenticationSystem")
    public void setup() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            Systgitem.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        authenticationSystemPage = new AuthenticationSystemPage(driver);
    }

    @AfterStep("@AuthenticationSystem")
    public void afterEachStep() {
        // to make the test at human speed
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After("@AuthenticationSystem")
    public void tearDown() {
        driver.quit();
    }

    @Given("I visit the welcome {string} page")
    public void i_visit_the_welcome_page(String string) {
        driver.get("http://localhost:8080" + string);
    }

    @Given("I am authenticated")
    public void i_am_authenticated() {
        authenticationSystemPage.becomeAuthenticated();
    }

    @Given("I am enrolled in the course")
    public void i_am_enrolled_in_the_course() {
        authenticationSystemPage.becomeEnrolled();
    }

    @When("I press the Join Lecture button")
    public void i_press_the_join_lecture_button() {
        authenticationSystemPage.clickJoinLectureButton();
    }

    @Then("I should be redirected to the lecture")
    public void i_should_be_redirected_to_the_lecture() {
        assertEquals(authenticationSystemPage.getLectureWelcomeText(), "Welcome to SOFTENG 754");
    }

    @Given("My authentication status is {string}")
    public void my_authentication_status_is(String string) {
        boolean authenticated = Boolean.parseBoolean(string);

        if (authenticated) {
            this.authenticationSystemPage.becomeAuthenticated();
        }
    }

    @Given("My enrolment status is {string}")
    public void my_enrolment_status_is(String string) {
        boolean enrolled = Boolean.parseBoolean(string);

        if (enrolled) {
            this.authenticationSystemPage.becomeEnrolled();
        }
    }

    @Then("I should not be redirected to the lecture")
    public void i_should_not_be_redirected_to_the_lecture() {
        assertEquals(authenticationSystemPage.getLectureName(), "SOFTENG 754");
        assertEquals(authenticationSystemPage.getErrorMessage(), "Invalid Credentials");
    }
}
