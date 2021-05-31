package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.SSOPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SSOStepDefinitions {

    private WebDriver driver;
    private SSOPage ssoPage;

    @Before("@Sso")
    public void setup() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ssoPage = new SSOPage(driver);
    }

    @AfterStep("@Sso")
    public void afterEachStep() {
        // to make the test at human speed
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After("@Sso")
    public void tearDown() {
        driver.quit();
    }

    @Given("I visit the login {string} page for sso")
    public void i_visit_the_login_page_for_sso(String string) {
        driver.get("http://localhost:8080" + string);
    }

    @When("I press the Sign in with SSO button")
    public void i_press_the_sign_in_with_sso_button() {
        ssoPage.clickSso();
    }

    @Then("I should see the SSO login page")
    public void i_should_see_the_sso_login_page() {
        assertEquals("Welcome SSO User!", ssoPage.getMessage());
        assertEquals("Thank you for signing in through SSO", ssoPage.getWelcomeText());
    }

    @Then("I can redirect to the welcome page")
    public void i_can_redirect_to_the_welcome_page() {
        ssoPage.clickRedirectButton();
        assertEquals("Welcome SSO User!", ssoPage.getMessage());
    }
}
