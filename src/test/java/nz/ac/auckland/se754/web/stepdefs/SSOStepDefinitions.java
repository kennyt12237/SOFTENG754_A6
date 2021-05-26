//package nz.ac.auckland.se754.web.stepdefs;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import nz.ac.auckland.se754.web.pages.UserAuthenticationPage;
//import nz.ac.auckland.se754.web.service.LectureSystem;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class SSOStepDefinitions {
//
//    private WebDriver driver;
//    private UserAuthenticationPage userAuthenticationPage;
//
//    @Before
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        userAuthenticationPage = new UserAuthenticationPage(driver);
//    }
//
//    @AfterStep
//    public void afterEachStep() {
//        // to make the test at human speed
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//
//    @When("I press the Sign in with SSO button")
//    public void i_press_the_sign_in_with_sso_button() {
//        userAuthenticationPage.clickSso();
//    }
//
//    @Then("I should see the SSO login page")
//    public void i_should_see_the_sso_login_page() {
//        assertTrue(userAuthenticationPage.getMessage().contains("Welcome SSO User"));
//    }
//
//}
