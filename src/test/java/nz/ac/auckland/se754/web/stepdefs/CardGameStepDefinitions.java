package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.CardGamePage;
import nz.ac.auckland.se754.web.service.CardGame.Card;
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
        //need to change win to macos when pushing and remove .exe
        //System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");

        System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        cardGamePage = new CardGamePage(driver);
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

    @Given("I visit a new page, {string}")
    public void i_visit_card_game(String string){
        driver.get("http://localhost:8080" + string);
    }

    @When("I click the help icon")
    public void i_have_pressed_help_icon(){
        cardGamePage.clickHelpIcon();
    }

    @Then("I should see the rules of the game")
    public void i_should_see_rules_of_game(){
        assertEquals("Last Card is a game in which each player takes turns placing cards that match the suit or value. You can place multiple cards at the same time, so long as they match value. If you're unable to place any cards, you must pick up 1. Whoever empties their hand first wins the game.",cardGamePage.getRules());
    }

    @Given("I have clicked the start game button")
    public void i_have_clicked_start_game_button(){
        cardGamePage.clickStartGameButton();
    }
    @Then("I should see a single card")
    public void i_should_see_single_card(){
       assertTrue(cardGamePage.validTopCard());

        //assertEquals("Diamonds", cardGamePage.getTopCardSuit());
        //assertEquals("10", cardGamePage.getTopCardValue());
    }
    @And("I should see the back of the deck")
    public void i_should_see_back_of_deck(){
        //Also not too sure of this test, but will need to figure things out first.
        assertTrue(cardGamePage.getDeckBack()=="Deck Back");
    }

    @Given("there is a deck of cards generated")
    public void thereIsADeckOfCardsGenerated() {
    }

    @Then("I should see a hand of {int} cards")
    public void iShouldSeeAHandOfCards(int arg0) {
    }

   /* @Given("There are {int} other students in the game with me")
    public void there_are_n_other_players_in_game(int noPlayers){
        cardGamePage.setNumberOfPlayers(noPlayers);
    }

    @When("I press the start game button")
    public void i_have_pressed_start_game_button(){
        cardGamePage.clickStartGameButton();
    }
    @Then("I should see that the game has started")
    public void i_should_see_that_the_game_has_started(){
        assertTrue(cardGamePage.getGameStarted());
    }

    @Then("I should see my hand of 7 cards")
    public void i_should_see_my_hand_of_7_cards(){
        assertTrue(cardGamePage.getPlayerHand());
    }*/



}
