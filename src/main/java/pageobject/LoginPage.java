package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(id="username")
	WebElement usernameInput;
	
	@FindBy(id="passwd")
	WebElement passwordInput;
	
	@FindBy(id="dob")
	WebElement dobInput;
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(id="error")
	WebElement errorElem;
	
    // Function to enter username
    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    // Function to enter password
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    // Function to enter date of birth
    public void enterDOB(String dob) {
        dobInput.sendKeys(dob);
    }

    // Function to click on the login button
    public void clickLoginButton() {
        loginButton.click();
    }

    // Function to submit the login form with provided credentials
    public void submitLoginForm(String username, String password, String dob) {
        enterUsername(username);
        enterPassword(password);
        enterDOB(dob);
        clickLoginButton();
    }
	
 // Function to verify if login page is displayed
    public boolean isLoginPageDisplayed() {
        // Verify elements are displayed
        return usernameInput.isDisplayed() &&
               passwordInput.isDisplayed() &&
               dobInput.isDisplayed() &&
               loginButton.isDisplayed();
    }
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkError() {
		
		return errorElem.getText().equals("Incorrect credentials.");
	}
	
}
