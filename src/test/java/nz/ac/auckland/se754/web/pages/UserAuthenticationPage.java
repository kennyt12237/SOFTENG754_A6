package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserAuthenticationPage {

    public UserAuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using ="username")
    private WebElement userName;

    @FindBy(how=How.ID, using="password")
    private WebElement password;

    @FindBy(how=How.ID, using="loginbtn")
    private WebElement loginButton;

    @FindBy(how=How.ID, using="message")
    private WebElement message;

    @FindBy(how=How.ID, using="ssobtn")
    private WebElement ssoButton;

    @FindBy(how=How.ID, using="sso-welcome-text")
    private WebElement ssoWelcomeText;

    @FindBy(how=How.ID, using="error-message")
    private WebElement errorMessage;

    @FindBy(how=How.ID, using="redirect-button")
    private WebElement redirectButton;

    @FindBy(how=How.ID, using="join-lecture-button")
    private WebElement joinLectureButton;

    @FindBy(how=How.ID, using="lecture-welcome")
    private WebElement lectureWelcome;

    public void insertUserName(String userName){
        this.userName.sendKeys(userName);
    }

    public void insertPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLogin(){
        this.loginButton.click();
    }

    public String getMessage(){
        return this.message.getText();
    }

    public void clickSso() {
        this.ssoButton.click();
    }

    public String getWelcomeText() {
        return this.ssoWelcomeText.getText();
    }

    public String getErrorMessage() {
        return this.errorMessage.getText();
    }

    public void clickRedirectButton() {
        this.redirectButton.click();
    }

    public void clickJoinLectureButton() {
        this.joinLectureButton.click();
    }

    public String getLectureWelcomeText() {
        return this.lectureWelcome.getText();
    }

}

