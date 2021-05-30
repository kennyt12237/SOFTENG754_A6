package nz.ac.auckland.se754.web.stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.QuestionSystemPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

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

    @AfterStep
    public void afterEachStep() {
        // to make the test at human speed
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("lecturer visits {string} and then logs in")
    public void lecturerVisitsAndThenLogsIn(String string) {
        driver.get("http://localhost:8080" + string);
        questionSystemPage.clickSso();
        questionSystemPage.clickRedirectToLecture();
        questionSystemPage.clickLecturerButton();
    }

    @Given("Lecturer receives question {string}")
    public void lecturer_receives_question(String string) {
        questionSystemPage.clickReceiveQuestionButton();
    }

    @When("Lecturer presses view question button")
    public void lecturer_presses_view_question_button() {
       questionSystemPage.clickViewQuestionButton();
    }

    @Then("Lecturer sees anonymous question as {string}")
    public void lecturer_sees_anonymous_question_as(String string) {
        String webQuestion = questionSystemPage.getQuestionText();
        String anonQuestion = "Anonymous: " + string;
        assertEquals(anonQuestion, webQuestion);
    }

    @And("Lecturer presses mark button")
    public void lecturerPressesMarkButton() {

    }

    @And("Lecturer sees question as marked {string}")
    public void lecturerSeesQuestionAsMarked(String string) {
    }
}