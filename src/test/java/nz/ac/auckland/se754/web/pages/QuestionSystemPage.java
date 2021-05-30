package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class QuestionSystemPage {

    public QuestionSystemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using="ssobtn")
    private WebElement ssoButton;

    @FindBy(how= How.ID, using="redirect-button")
    private WebElement redirectButton;

    @FindBy(how= How.ID, using="lecturerBtn")
    private WebElement lecturerButton;

    @FindBy(how= How.ID, using="receiveBtn")
    private WebElement receiveQuestionButton;

    @FindBy(how= How.ID, using="viewBtn")
    private WebElement viewQuestionButton;

    @FindBy(how= How.ID, using="questionText")
    private WebElement questionText;

    @FindBy(how= How.ID, using="markBtn")
    private WebElement markButton;

    @FindBy(how= How.ID, using="isMarkedText")
    private WebElement markText;

    @FindBy(how= How.ID, using="flagBtn")
    private WebElement flagButton;

    @FindBy(how= How.ID, using="deleteBtn")
    private WebElement deleteButton;

    @FindBy(how= How.ID, using="storeBtn")
    private WebElement storeButton;

    @FindBy(how= How.ID, using="isStoredText")
    private WebElement storedText;

    @FindBy(how= How.ID, using="dbQuestionBtn")
    private WebElement dbQuestionBtn;

    @FindBy(how= How.ID, using="dbQuestionsText")
    private WebElement dbQuestionsText;


    public void clickSso() {
        this.ssoButton.click();
    }

    public void clickRedirectToLecture() {
        this.redirectButton.click();
    }

    public void clickLecturerButton() {
        this.lecturerButton.click();
    }

    public void clickReceiveQuestionButton() {
        this.receiveQuestionButton.click();
    }

    public void clickViewQuestionButton() {
        this.viewQuestionButton.click();
    }

    public String getQuestionText() {
        return this.questionText.getText();
    }

    public void clickMarkButton() {
        markButton.click();
    }

    public String getMarkText() {
        return this.markText.getText();
    }

    public void clickFlagButton() {
        flagButton.click();
    }
    
    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickStoreButton() {
        storeButton.click();
    }

    public String getStoredText() {
        return this.storedText.getText();
    }

    public void clickDBQuestionButton() {
        dbQuestionBtn.click();
    }

    public String getDBQuestionsText() {
        return this.dbQuestionsText.getText();
    }
}
