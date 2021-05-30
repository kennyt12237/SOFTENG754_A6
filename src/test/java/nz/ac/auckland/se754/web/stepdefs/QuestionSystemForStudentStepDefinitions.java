package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.QuestionSystemForStudentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class QuestionSystemForStudentStepDefinitions {

    private WebDriver driver;
    private QuestionSystemForStudentPage questionSystemForStudentPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        questionSystemForStudentPage = new QuestionSystemForStudentPage(driver);
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

    @Given("Student visits {string} and then logs in")
    public void studentVisitsAndThenLogsIn(String string) {
        driver.get("http://localhost:8080" + string);
        questionSystemForStudentPage.clickSso();
        questionSystemForStudentPage.clickRedirectToLecture();
        questionSystemForStudentPage.becomeAuthenticated();
        questionSystemForStudentPage.becomeEnrolled();
        questionSystemForStudentPage.clickJoinLectureButton();
    }

    @Then("Student should see anonymous question {string}")
    public void studentShouldSeeAnonymousQuestion(String string) {
        String questionTxt = questionSystemForStudentPage.getQuestionText();
        assertEquals(string, questionTxt);
    }

    @When("Student writes question {string}")
    public void studentWritesQuestion(String string) {
        questionSystemForStudentPage.insertQuestion(string);
    }

    @And("Student presses ask question button")
    public void studentPressesAskQuestionButton() {
        questionSystemForStudentPage.clickAskQuestionButton();
    }

    @And("Student checks the urgent checkbox")
    public void studentChecksTheUrgentCheckbox() {
        questionSystemForStudentPage.becomeUrgent();
    }

    @And("Student upvote the question")
    public void studentUpvoteTheQuestion() {
        
    }

    @Then("Student should see upvote count {string}")
    public void studentShouldSeeUpvoteCount(String arg0) {
    }
}
