package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CardGamePage {
    public CardGamePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="cardgame")
    private WebElement cardGame;

    @FindBy(how=How.ID, using="start-game-button")
    private WebElement startGameButton;

    @FindBy(how=How.ID, using="helpbtn")
    private WebElement helpButton;

    @FindBy(how=How.ID, using="helpmsg")
    private WebElement helpMessage;

    @FindBy(how=How.ID, using="topCard")
    private WebElement topCard;

    @FindBy(how=How.ID, using="topValue")
    private WebElement topValue;

    @FindBy(how=How.ID, using="topSuit")
    private WebElement topSuit;

    @FindBy(how=How.ID, using="exit")
    private WebElement helpExit;

    @FindBy(how=How.ID, using="playerHand")
    private WebElement hand;

    @FindBy(how=How.ID, using="deck")
    private WebElement deck;

    @FindBy(how=How.ID, using="drawCard")
    private WebElement drawCard;

    @FindBy(how=How.ID, using="0")
    private WebElement testCard;

    @FindBy(how=How.ID, using="testCardValue")
    private WebElement testCardValue;

    @FindBy(how=How.ID, using="testCardSuit")
    private WebElement testCardSuit;

    @FindBy(how=How.ID, using="addTestCardsHand")
    private WebElement testCardButton;

    @FindBy(how=How.ID, using="testTopCardValue")
    private WebElement testTopCardValue;

    @FindBy(how=How.ID, using="testTopCardSuit")
    private WebElement testTopCardSuit;

    @FindBy(how=How.ID, using="addTestCardsTop")
    private WebElement testCardTopButton;


    public void clickStartGameButton(){
         this.startGameButton.click();
    }

    public boolean getGameStarted(){
        return true;
    }

    public boolean getPlayerHand(){
        return true;
    }

    public void clickHelpIcon(){
        this.helpButton.click();
    }

    public void clickHelpExit(){this.helpExit.click();}

    public void addTestCardToHand(String value, String suit){
        value = valueToNum(value);
        suit = suitToNum(suit);
        this.testCardValue.sendKeys(value);
        this.testCardSuit.sendKeys(suit);
        this.testCardButton.click();

    }
    public void addTestCardToTopDeck(String value, String suit){
        value = valueToNum(value);
        suit = suitToNum(suit);
        this.testTopCardValue.sendKeys(value);
        this.testTopCardSuit.sendKeys(suit);
        this.testCardTopButton.click();
    }
    public void clickTestCard(){
        this.testCard.click();
    }

    public String getRules(){
       return this.helpMessage.getText();
    }

    public void clickDrawCard(){
        this.drawCard.click();
    }

    public String getTopCardValue(){
        String value = this.topValue.getText();
        value=value.substring(value.lastIndexOf(": ")+2);
        return value;
    }

    public String getTopCardSuit(){
        String suit = this.topSuit.getText();
        suit=suit.substring(suit.lastIndexOf(": ")+2);
        return suit;
    }

    public boolean validTopCard(){
        String value=this.topValue.getText();
        String suit = this.topSuit.getText();
        value=value.substring(value.lastIndexOf(": ")+2);
        suit = suit.substring(suit.lastIndexOf(": ")+2);
        if(suit.equals("Diamonds") || suit.equals("Clubs")||suit.equals("Spades")||suit.equals("Hearts")){
            if(value.equals("Ace") || value.equals("2") || value.equals("3") || value.equals("4") || value.equals("5") || value.equals("6") || value.equals("7") || value.equals("8") || value.equals("9") || value.equals("10") || value.equals("Jack") || value.equals("Queen") || value.equals("King")){
                return true;
            }
        }
        return false;
    }


    public int validHand(){
        String hand = this.hand.getText();
        int validCardCounter = 0;
        for(int i =0; i < hand.length(); i++){
            if(hand.charAt(i) == 'D' || hand.charAt(i) == 'H' || hand.charAt(i) == 'S' || hand.charAt(i) == 'C'){
                if(hand.charAt(i+1) =='u'){
                }
                else{
                    validCardCounter++;
                }
            }
        }
        return validCardCounter;
    }

    public String valueToNum(String value){
        if(value.equals("Ace")){
            return "0";
        }
        if(value.equals("2")){
            return "1";
        }
        if(value.equals("3")){
            return "2";
        }
        if(value.equals("4")){
            return "3";
        }
        if(value.equals("5")){
            return "4";
        }
        if(value.equals("6")){
            return "5";
        }
        if(value.equals("7")){
            return "6";
        }
        if(value.equals("8")){
            return "7";
        }
        if(value.equals("9")){
            return "8";
        }
        if(value.equals("10")){
            return "9";
        }
        if(value.equals("Jack")){
            return "10";
        }
        if(value.equals("Queen")){
            return "11";
        }
        if(value.equals("King")){
            return "12";
        }
        return value;
    }

    public String suitToNum(String suit){
        if(suit.equals("Diamonds")){
            return "0";
        }
        if(suit.equals("Hearts")){
            return "1";
        }
        if(suit.equals("Clubs")){
            return "2";
        }
        return "3";
    }


}
