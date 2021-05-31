package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StudentRoomPage {


    public StudentRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "breakoutroom")
    private List<WebElement> breakoutRooms;

    @FindBy(how = How.CLASS_NAME, using = "joinbtn")
    private WebElement joinButton;

    @FindBy(how = How.ID, using = "finishbtn")
    private WebElement finishButton;

    @FindBy(how = How.ID, using = "callbtn")
    private WebElement inviteButton;

    public int GetBreakoutRoomCount() {
        return breakoutRooms.size();
    }

    public void clickJoin() {
        this.joinButton.click();
    }

    public void clickFinish() {
        this.finishButton.click();
    }

    public void clickInvite() {
        this.inviteButton.click();
    }
}

