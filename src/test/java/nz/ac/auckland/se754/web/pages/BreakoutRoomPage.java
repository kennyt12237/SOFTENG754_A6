package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BreakoutRoomPage {

    public BreakoutRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "breakoutroom")
    private List<WebElement> breakoutRooms;

    @FindBy(how = How.CLASS_NAME, using = "mbkstudent")
    private List<WebElement> users;

    @FindBy(how = How.ID, using = "addbtn")
    private WebElement addButton;

    @FindBy(how = How.ID, using = "enablebtn")
    private WebElement enableButton;

    @FindBy(how = How.ID, using = "disablebtn")
    private WebElement disableButton;

    @FindBy(how = How.ID, using = "breakoutstatus")
    private WebElement status;

    @FindBy(how = How.CLASS_NAME, using = "topicbtn")
    private WebElement topicLink;

    @FindBy(how = How.CLASS_NAME, using = "topic")
    private WebElement topicString;

    @FindBy(how = How.ID, using = "topicname")
    private WebElement topicTextbox;

    @FindBy(how = How.ID, using = "addtopicbtn")
    private WebElement addTopicBtn;

    @FindBy(how = How.ID, using = "importcanvas")
    private WebElement importBtn;

    @FindBy(how = How.ID, using = "reset")
    private WebElement resetBtn;

    @FindBy(how = How.CLASS_NAME, using = "finishedbtn")
    private List<WebElement> finishButtonList;

    @FindBy(how = How.CLASS_NAME, using = "invitebtn")
    private List<WebElement> inviteButtonList;

    public void clickAdd() {
        this.addButton.click();
    }

    public void clickEnable() {
        this.enableButton.click();
    }

    public void clickDisable() {
        this.disableButton.click();
    }

    public int GetBreakoutRoomCount() {
        return breakoutRooms.size();
    }

    public String getStatusString() {
        return status.getText();
    }

    public void clickTopic() {
        this.topicLink.click();
    }

    public String getTopic() {
        return topicString.getText();
    }

    public void setTopic(String string) {
        this.topicTextbox.sendKeys(string);
    }

    public void clickAddTopic() {
        this.addTopicBtn.click();
    }

    public void clickImport() {
        this.importBtn.click();
    }

    public List<String> getUsers() {
        ArrayList<String> usr = new ArrayList<>();
        for (WebElement u : users) {
            usr.add(u.getText());
        }
        return usr;
    }

    public void clickReset() {
        this.resetBtn.click();
    }

    public int checkFinish() {
        return this.finishButtonList.size();
    }

    public int checkInvite() {
        return this.inviteButtonList.size();
    }

    public void clickInvite() {
        this.inviteButtonList.get(0).click();
    }
}

