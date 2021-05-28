package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.service.LectureSystem;
import nz.ac.auckland.se754.web.pages.UserAuthenticationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class CardGameStepDefinitions {
    private WebDriver driver;
    private CardGamePage cardGamePage;
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        cardGamePage = new CardGamePage(driver);
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


}
