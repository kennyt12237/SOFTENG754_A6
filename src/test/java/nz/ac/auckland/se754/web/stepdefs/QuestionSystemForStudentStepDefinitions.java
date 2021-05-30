package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.QuestionSystemForLecturerPage;
import nz.ac.auckland.se754.web.pages.QuestionSystemForStudentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

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
    }

    @When("Student asks question {string}")
    public void studentAsksQuestion(String string) {

    }

    @Then("Student should see anonymous question {string}")
    public void studentShouldSeeAnonymousQuestion(String string) {
    }
}
