//package nz.ac.auckland.se754.web.stepdefs;
//
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import nz.ac.auckland.se754.web.pages.UserAuthenticationPage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class AuthenticationSystemStepDefinitions {
//
//    private boolean authenticated, enrolled;
//
//    private UserAuthenticationPage userAuthenticationPage;
//    private LecturePage lecturePage;
//    private WebDriver driver;
//
//    @Before
//    public void setup() {
//        lecturePage = new LecturePage(driver);
//        userAuthenticationPage = new UserAuthenticationPage(driver);
//    }
//
////    @Before
////    public void setup() {
////        System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
////        driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////        userAuthenticationPage = new UserAuthenticationPage(driver);
////    }
//
////    @AfterStep
////    public void afterEachStep() {
////        // to make the test at human speed
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////    }
//
////    @After
////    public void tearDown() {
////        driver.quit();
////    }
//
//    @Given("I am authenticated")
//    public void i_am_authenticated() {
//        this.authenticated = true;
//    }
//
//    @Given("I am enrolled in the course")
//    public void i_am_enrolled_in_the_course() {
//        this.enrolled = true;
//    }
//
//    @When("I press the Join Lecture button")
//    public void i_press_the_join_lecture_button() {
////        this.lecturePage.clickJoinLectureButton();
//        driver.findElement(By.name("join-lecture-button")).click();
//    }
//
//    @Then("I should be redirected to the lecture")
//    public void i_should_be_redirected_to_the_lecture() {
//        assertEquals(lecturePage.getLectureWelcomeText(), "Welcome to SOFTENG754");
//    }
//
//}
