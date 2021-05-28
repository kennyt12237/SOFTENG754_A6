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


}
