package nz.ac.auckland.se754.web.stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.QuestionSystemForLecturerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionSystemForLecturerStepDefinitions {

    private WebDriver driver;
    private QuestionSystemForLecturerPage questionSystemForLecturerPage;

    @Before("@QuestionSystemForLecturer")
    public void setup() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        questionSystemForLecturerPage = new QuestionSystemForLecturerPage(driver);
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


    @Given("lecturer visits {string} and then logs in")
    public void lecturer_visits_and_then_logs_in(String string) {
        driver.get("http://localhost:8080" + string);
        questionSystemForLecturerPage.clickSso();
        questionSystemForLecturerPage.clickRedirectToLecture();
        questionSystemForLecturerPage.clickLecturerButton();
    }

    @Given("Lecturer receives question {string}")
    public void lecturer_receives_question(String string) {
        questionSystemForLecturerPage.clickReceiveQuestionButton();
    }

    @When("Lecturer presses view question button")
    public void lecturer_presses_view_question_button() {
        questionSystemForLecturerPage.clickViewQuestionButton();
    }

    @Then("Lecturer sees anonymous question as {string}")
    public void lecturer_sees_anonymous_question_as(String string) {
        String webQuestion = questionSystemForLecturerPage.getQuestionText();
        assertEquals(string, webQuestion);
    }

    @And("Lecturer presses mark button")
    public void lecturer_presses_mark_button() {
        questionSystemForLecturerPage.clickMarkButton();
    }

    @And("Lecturer sees question mark alert {string}")
    public void lecturer_sees_question_mark_alert(String string) {
        String markText = questionSystemForLecturerPage.getMarkText();
        assertEquals(string, markText);
    }

    @And("Lecturer presses the flag button")
    public void lecturer_presses_the_flag_button() {
        questionSystemForLecturerPage.clickFlagButton();
    }

    @And("Lecturer sees question flag alert {string}")
    public void lecturerSeesQuestionFlagAlert(String string) {
        String flagText = questionSystemForLecturerPage.getFlaggedText();
        assertEquals(string, flagText);
    }

    @And("Lecturer presses the delete button")
    public void lecturer_presses_the_delete_button() {
        questionSystemForLecturerPage.clickDeleteButton();
    }

    @And("Lecturer presses the store button")
    public void lecturer_presses_the_store_button() {
        questionSystemForLecturerPage.clickStoreButton();
    }

    @And("Lecturer sees question database alert {string}")
    public void lecturer_sees_question_database_alert(String string) {
        questionSystemForLecturerPage.getStoredText();
    }

    @When("Lecturer presses View Database")
    public void lecturer_presses_view_database() {
        questionSystemForLecturerPage.clickDBQuestionButton();
    }

    @Then("Lecturer sees question in database {string}")
    public void lecturer_sees_question_in_database(String string) {
        String dbQuestion = questionSystemForLecturerPage.getDBQuestionsText();
        assertEquals(string, dbQuestion);
    }
}