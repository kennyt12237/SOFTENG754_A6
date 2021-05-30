package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SSOPage {

    @FindBy(how= How.ID, using="redirect-button")
    private WebElement redirectButton;

    @FindBy(how=How.ID, using="ssobtn")
    private WebElement ssoButton;

    @FindBy(how=How.ID, using="sso-welcome-text")
    private WebElement ssoWelcomeText;

    @FindBy(how=How.ID, using="message")
    private WebElement message;

    public SSOPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickRedirectButton() {
        this.redirectButton.click();
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

}
