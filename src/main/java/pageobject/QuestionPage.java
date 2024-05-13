package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionPage {

	   private WebDriver driver;

	    @FindBy(id = "number1")
	    private WebElement number1Input;

	    @FindBy(id = "number2")
	    private WebElement number2Input;

	    @FindBy(id = "result")
	    private WebElement resultInput;
	    
	    @FindBy(xpath="//h2")
	    private WebElement header;

	    @FindBy(xpath = "//input[@type='submit']")
	    private WebElement submitButton;
	    
	    @FindBy(id="error")
	    private WebElement errorElem;

	    public QuestionPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Function to enter first number
	    public void enterFirstNumber(String number) {
	        number1Input.sendKeys(number);
	    }

	    // Function to enter second number
	    public void enterSecondNumber(String number) {
	        number2Input.sendKeys(number);
	    }

	    // Function to get the result text
	    public void enterResult(String number) {
	        resultInput.sendKeys(number);
	    }

	    // Function to click on the submit button
	    public void clickSubmitButton() {
	        submitButton.click();
	    }

	    // Function to submit the form with provided numbers
	    public void submitForm(String number1, String number2, String number3) {
	        enterFirstNumber(number1);
	        enterSecondNumber(number2);
	        enterResult(number3);
	        clickSubmitButton();
	    }
	    
	    public boolean checkHeader(String hText) {
	    	return header.getText().equals(hText);
	    }

	    // Function to verify if Q1 page is displayed
	    public boolean isQPageDisplayed(String pageName) {
	        // Verify elements are displayed
	        return number1Input.isDisplayed() &&
	               number2Input.isDisplayed() &&
	               submitButton.isDisplayed() && checkHeader(pageName) ;
	    }
	    
	    public boolean checkError() {
//	    	Wrong answer, try again./
	    	return errorElem.getText().equals("Wrong answer, try again.");
	    }
}
