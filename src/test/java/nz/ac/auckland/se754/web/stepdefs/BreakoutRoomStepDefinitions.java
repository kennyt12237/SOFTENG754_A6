package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.BreakoutRoomPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class BreakoutRoomStepDefinitions {

    private WebDriver driver;
    private BreakoutRoomPage breakoutRoomPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        breakoutRoomPage = new BreakoutRoomPage(driver);
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

    @Given("the students {string} and {string} and {string} are in the mainroom")
    public void the_students_and_and_are_in_the_mainroom(String string, String string2, String string3) {

    }

    @Given("I visit page {string}")
    public void i_visit_page(String string) {
        driver.get("http://localhost:8080" + string);
    }

    @When("I press the Add button {int} times")
    public void i_press_the_add_button_times(Integer int1) {
        for (int i = 0; i < int1; i++) {
            breakoutRoomPage.clickAdd();
        }
    }

    @Then("I should see {int} breakout rooms created")
    public void i_should_see_breakout_rooms_created(Integer int1) {
        assertEquals(int1, breakoutRoomPage.GetBreakoutRoomCount());
    }

    @When("I press the Enable button")
    public void i_press_the_enable_button() {
        breakoutRoomPage.clickEnable();
    }

    @When("I press the Disable button")
    public void i_press_the_disable_button() {
        breakoutRoomPage.clickDisable();
    }

    @Then("I should see {string}")
    public void i_should_see(String message) {
        assertEquals(message,breakoutRoomPage.getStatusString());
    }



}
