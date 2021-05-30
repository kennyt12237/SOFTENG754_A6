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

    @Before("@QuestionSystemForStudent")
    public void setup() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        questionSystemForStudentPage = new QuestionSystemForStudentPage(driver);
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

    @Then("Student should see anonymous question {string}")
    public void student_should_see_anonymous_question(String string) {
        String questionTxt = questionSystemForStudentPage.getQuestionText();
        assertEquals(string, questionTxt);
    }

    @When("Student writes question {string}")
    public void student_writes_question(String string) {
        questionSystemForStudentPage.insertQuestion(string);
    }

    @And("Student presses ask question button")
    public void student_presses_ask_question_button() {
        questionSystemForStudentPage.clickAskQuestionButton();
    }

    @And("Student checks the urgent checkbox")
    public void student_checks_the_urgent_checkbox() {
        questionSystemForStudentPage.becomeUrgent();
    }

    @And("Student upvote the question")
    public void student_upvote_the_question() {
        questionSystemForStudentPage.clickUpvoteButton();
    }

    @Then("Student should see upvote count {string}")
    public void student_should_see_upvote_count(String string) {
        int expUpvoteCount = Integer.parseInt(string);
        int actUpvoteCount = Integer.parseInt(questionSystemForStudentPage.getUpvoteCountText());
        assertEquals(expUpvoteCount, actUpvoteCount);
    }

    @Given("Student visits the site {string}")
    public void student_visits_the_site(String string) {
        driver.get("http://localhost:8080" + string);
    }

    @And("Student logs in proceeding to lecture")
    public void student_logs_in_proceeding_to_lecture() {
        questionSystemForStudentPage.clickSso();
        questionSystemForStudentPage.clickRedirectToLecture();
        questionSystemForStudentPage.becomeAuthenticated();
        questionSystemForStudentPage.becomeEnrolled();
        questionSystemForStudentPage.clickJoinLectureButton();
    }
}
