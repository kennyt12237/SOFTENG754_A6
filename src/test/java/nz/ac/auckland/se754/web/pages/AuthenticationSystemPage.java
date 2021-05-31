package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationSystemPage {

    @FindBy(how=How.ID, using="error-message")
    private WebElement errorMessage;

    @FindBy(how=How.ID, using="join-lecture-button")
    private WebElement joinLectureButton;

    @FindBy(how=How.ID, using="lecture-welcome")
    private WebElement lectureWelcome;

    @FindBy(how=How.ID, using="softeng-754")
    private WebElement softeng754;

    @FindBy(how=How.ID, using="authenticated")
    private WebElement authenticated;

    @FindBy(how=How.ID, using="enrolled")
    private WebElement enrolled;

    public AuthenticationSystemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getErrorMessage() {
        return this.errorMessage.getText();
    }

    public void clickJoinLectureButton() {
        this.joinLectureButton.click();
    }

    public String getLectureWelcomeText() {
        return this.lectureWelcome.getText();
    }

    public String getLectureName() {
        return this.softeng754.getText();
    }

    public void becomeAuthenticated() {
        this.authenticated.click();
    }

    public void becomeEnrolled() {
        this.enrolled.click();
    }
}
