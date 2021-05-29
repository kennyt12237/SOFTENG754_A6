package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BreakoutRoomPage {

    public BreakoutRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.CLASS_NAME, using ="breakoutroom")
    private List<WebElement> breakoutRooms;

    @FindBy(how=How.ID, using="addbtn")
    private WebElement addButton;

    @FindBy(how = How.ID, using = "enablebtn")
    private WebElement enableButton;

    @FindBy(how = How.ID, using = "disablebtn")
    private WebElement disableButton;

    @FindBy(how = How.ID, using = "breakoutstatus")
    private WebElement status;

    public void clickAdd(){
        this.addButton.click();
    }

    public void clickEnable() {
        this.enableButton.click();
    }

    public void clickDisable() {
        this.disableButton.click();
    }

    public int GetBreakoutRoomCount(){
        return breakoutRooms.size();
    }

    public String getStatusString()
    {
        return status.getText();
    }
}

