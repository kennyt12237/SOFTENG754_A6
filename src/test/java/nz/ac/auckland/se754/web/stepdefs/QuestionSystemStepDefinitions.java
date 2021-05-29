package nz.ac.auckland.se754.web.stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.QuestionSystemPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class QuestionSystemStepDefinitions {

    private WebDriver driver;
    private QuestionSystemPage questionSystemPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        questionSystemPage = new QuestionSystemPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("Lecturer receives question {string}")
    public void lecturer_receives_question(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Lecturer presses view question button")
    public void lecturer_presses_view_question_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Lecturer sees anonymous question as {string}")
    public void lecturer_sees_anonymous_question_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}