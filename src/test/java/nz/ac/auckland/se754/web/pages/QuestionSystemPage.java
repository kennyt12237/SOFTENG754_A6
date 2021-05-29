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

    @FindBy(how= How.ID, using="receiveBtn")
    private WebElement receiveQuestionButton;

    @FindBy(how= How.ID, using="viewBtn")
    private WebElement viewQuestionButton;

    @FindBy(how= How.ID, using="questionText")
    private WebElement questionText;


}
