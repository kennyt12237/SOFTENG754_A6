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
}
