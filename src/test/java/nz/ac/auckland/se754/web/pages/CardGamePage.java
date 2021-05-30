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

    public String getRules(){
       return this.helpMessage.getText();
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

    public String getDeckBack(){
        return "Deck Back";
    }
}
