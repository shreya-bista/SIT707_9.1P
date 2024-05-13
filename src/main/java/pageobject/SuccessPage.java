package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {

    private WebDriver driver;

    @FindBy(xpath = "//h2")
    private WebElement congratulationsHeader;

    @FindBy(xpath = "//h2/following-sibling::text()[1]")
    private WebElement completionMessage;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Function to check if the Congratulations page is displayed
    public boolean isCongratulationsPageDisplayed() {
        // Verify elements are displayed
        return congratulationsHeader.getText().equals("Congratulations");
    }

    // Function to get the completion message
    public String getCompletionMessage() {
        return completionMessage.getText();
    }
}
