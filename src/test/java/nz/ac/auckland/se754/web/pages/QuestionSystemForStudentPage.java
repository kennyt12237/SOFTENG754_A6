package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class QuestionSystemForStudentPage {

    public QuestionSystemForStudentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using="ssobtn")
    private WebElement ssoButton;

    @FindBy(how= How.ID, using="redirect-button")
    private WebElement redirectButton;

    @FindBy(how= How.ID, using="authenticated")
    private WebElement authenticatedCheckBox;

    @FindBy(how= How.ID, using="enrolled")
    private WebElement enrolledCheckBox;

    @FindBy(how= How.ID, using="join-lecture-button")
    private WebElement joinLectureButton;

    @FindBy(how= How.ID, using="question")
    private WebElement questionTextBox;

    @FindBy(how= How.ID, using="askQuestionBtn")
    private WebElement askQuestionButton;

    @FindBy(how= How.ID, using="questionText")
    private WebElement questionText;

    @FindBy(how= How.ID, using="urgent")
    private WebElement urgentCheckBox;

    public void clickSso() {
        this.ssoButton.click();
    }

    public void clickRedirectToLecture() {
        this.redirectButton.click();
    }

    public void becomeAuthenticated() {
        this.authenticatedCheckBox.click();
    }

    public void becomeEnrolled() {
        this.enrolledCheckBox.click();
    }

    public void clickJoinLectureButton() {
        this.joinLectureButton.click();
    }

    public void insertQuestion(String question){
        this.questionTextBox.sendKeys(question);
    }

    public void clickAskQuestionButton() {
        this.askQuestionButton.click();
    }

    public String getQuestionText() {
        return this.questionText.getText();
    }

    public void becomeUrgent() {
        this.urgentCheckBox.click();
    }


}
