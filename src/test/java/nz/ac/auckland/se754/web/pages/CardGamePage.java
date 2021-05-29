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

    public void setNumberOfPlayers(int noPlayers){
        //i don't fucking know.
    }

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

    public String getRules(){
       return this.helpMessage.getText();
    }

}
