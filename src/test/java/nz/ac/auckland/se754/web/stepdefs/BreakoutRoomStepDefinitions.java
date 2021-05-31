package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.BreakoutRoomPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

    @Given("the Lecturer and students {string} and {string} and {string}  and {string} and {string} are in the mainroom")
    public void the_lecturer_and_students_and_and_and_and_are_in_the_mainroom(String string, String string2, String string3, String string4, String string5) {
    }


    @Given("I visit page {string}")
    public void i_visit_page(String string) {
        driver.get("http://localhost:8080" + string);
        breakoutRoomPage.clickReset();
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
        assertEquals(message, breakoutRoomPage.getStatusString());
    }

    @Given("There is a breakout room")
    public void there_is_a_breakout_room() {
        if (breakoutRoomPage.GetBreakoutRoomCount() == 0) {
            breakoutRoomPage.clickAdd();
        }
    }

    @When("I click on the Topic Link of the breakout room")
    public void i_click_on_the_topic_link_of_the_breakout_room() {
        breakoutRoomPage.clickTopic();

    }

    @When("Type in {string} as the topic name")
    public void type_in_as_the_topic_name(String name) {
        driver.getCurrentUrl();
        breakoutRoomPage.setTopic(name);
    }

    @When("press Add topic button.")
    public void press_add_topic_button() {
        breakoutRoomPage.clickAddTopic();
    }

    @Then("I should see {string} as the topic name for that breakout room.")
    public void i_should_see_as_the_topic_name_for_that_breakout_room(String message) {
        driver.getCurrentUrl();
        assertEquals(message, breakoutRoomPage.getTopic());
    }

    @Given("The Canvas Group contains {int} groups")
    public void the_canvas_group_contains_groups(Integer int1) {
    }

    @When("I press the Import button")
    public void i_press_the_import_button() {
        breakoutRoomPage.clickImport();
    }

    @Given("Lecturer visit page {string}")
    public void lecturer_visit_page(String string) {
        driver.get("http://localhost:8080" + string);
    }


    @When("the Lecturer presses the Enable button")
    public void the_lecturer_presses_the_enable_button() {
        breakoutRoomPage.clickEnable();
    }

    @Then("I should be able to see {string} in the breakout room.")
    public void i_should_be_able_to_see_in_the_breakout_room(String string) {
        driver.navigate().refresh();
        assertTrue(breakoutRoomPage.getUsers().contains(string));
    }

    @Then("the lecturer should see Finished on the breakout room.")
    public void the_lecturer_should_see_finished_on_the_breakout_room() {
        driver.get("http://localhost:8080/mainroom-lecturer-screen");
        assertEquals(1,breakoutRoomPage.checkFinish());
    }

    @Then("the lecturer should see Invite on the breakout room.")
    public void the_lecturer_should_see_invite_on_the_breakout_room() {
        driver.get("http://localhost:8080/mainroom-lecturer-screen");
        assertEquals(1,breakoutRoomPage.checkInvite());
    }
}
