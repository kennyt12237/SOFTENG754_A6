package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.StudentRoomPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class StudentRoomStepDefinitions {

    private WebDriver driver;
    private StudentRoomPage studentRoomPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        studentRoomPage = new StudentRoomPage(driver);
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

    @Given("I visit page {string} as {string}")
    public void i_visit_page_as(String link, String userName) {
        driver.get("http://localhost:8080" + link +"?user=" + userName);
    }

    @Then("I should see breakout rooms open")
    public void i_should_see_breakout_rooms_open() {
        driver.navigate().refresh();
        assertNotEquals(0,studentRoomPage.GetBreakoutRoomCount());
    }

    @When("students {string} joins The breakout room")
    public void students_joins_the_breakout_room(String string) {
        driver.get("http://localhost:8080/student-room?user=" + string);
        studentRoomPage.clickJoin();
    }

}
