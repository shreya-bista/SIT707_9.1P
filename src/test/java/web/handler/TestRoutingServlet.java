package web.handler;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobject.LoginPage;
import pageobject.QuestionPage;
import pageobject.SuccessPage;

public class TestRoutingServlet {

	private WebDriver driver;
	public static String LOGIN_URL = "/login";
	public static String Q1_URL = "/q1";
	public static String Q2_URL = "/q2";
	public static String Q3_URL = "/q3";
	public static String SUCCESS_URL = "/sucess";
	public static String BASE_URL = "http://localhost:8080";

	public static String username = "shreya";
	public static String password = "shreya_pass";
	public static String dob = "12/12/2023";

	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	public void testInvalidLogin() {
		driver.get(BASE_URL + LOGIN_URL);
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isLoginPageDisplayed());

		loginPage.submitLoginForm("afdf", "dfd", "11/11/2023");

		assertTrue(loginPage.checkError());
		assertTrue(loginPage.isLoginPageDisplayed());
	}

	@Test
	public void testInvalidLoginEmptyUsername() {
		driver.get(BASE_URL + LOGIN_URL);
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isLoginPageDisplayed());

		loginPage.submitLoginForm("", password, dob);

		assertTrue(loginPage.checkError());
		assertTrue(loginPage.isLoginPageDisplayed());
	}

	@Test
	public void testInvalidUsername() {
		driver.get(BASE_URL + LOGIN_URL);
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isLoginPageDisplayed());

		loginPage.submitLoginForm("invalid_username", password, dob);

		assertTrue(loginPage.checkError());
		assertTrue(loginPage.isLoginPageDisplayed());
	}

	@Test
	public void testInvalidPassword() {
		driver.get(BASE_URL + LOGIN_URL);
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isLoginPageDisplayed());

		loginPage.submitLoginForm(username, "invalid_password", dob);

		assertTrue(loginPage.checkError());
		assertTrue(loginPage.isLoginPageDisplayed());
	}

	@Test
	public void testEmptyUsername() {
		driver.get(BASE_URL + LOGIN_URL);
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isLoginPageDisplayed());

		loginPage.submitLoginForm("", password, dob);

		assertTrue(loginPage.checkError());
		assertTrue(loginPage.isLoginPageDisplayed());
	}

	@Test
	public void testEmptyPassword() {
		driver.get(BASE_URL + LOGIN_URL);
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isLoginPageDisplayed());

		loginPage.submitLoginForm(username, "", dob);

		assertTrue(loginPage.checkError());
		assertTrue(loginPage.isLoginPageDisplayed());
	}

	@Test
	public void testEmptyUsernameAndPassword() {
		driver.get(BASE_URL + LOGIN_URL);
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isLoginPageDisplayed());

		loginPage.submitLoginForm("", "", dob);

		assertTrue(loginPage.checkError());
		assertTrue(loginPage.isLoginPageDisplayed());
	}

	@Test
	public void testSucessfulLoginNavigateToAllPages() {
		driver.get(BASE_URL + LOGIN_URL);
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isLoginPageDisplayed());

		loginPage.submitLoginForm(username, password, dob);

		QuestionPage qPage = new QuestionPage(driver);
		qPage.isQPageDisplayed("Q1");

		qPage.submitForm("1", "1", "2");
		qPage.isQPageDisplayed("Q2");
		qPage.submitForm("1", "1", "0");
		qPage.isQPageDisplayed("Q3");
		qPage.submitForm("1", "1", "2");

		SuccessPage sPage = new SuccessPage(driver);
		Assert.assertTrue(sPage.isCongratulationsPageDisplayed());
	}
	
	@Test
	public void testEmptyNumber1AndNumber2Q1Page() {
		driver.get(BASE_URL + LOGIN_URL);
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isLoginPageDisplayed());

		loginPage.submitLoginForm(username, password, dob);

		QuestionPage qPage = new QuestionPage(driver);
		Assert.assertTrue(qPage.isQPageDisplayed("Q1"));
		qPage.submitForm("", "", "");
		
		Assert.assertTrue(qPage.checkError());
		Assert.assertTrue(qPage.isQPageDisplayed("Q1"));
	}
	
    @Test
    public void testValidSubmissionQ1Page() {
        driver.get(BASE_URL + LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoginPageDisplayed());

        loginPage.submitLoginForm(username, password, dob);

        QuestionPage qPage = new QuestionPage(driver);
        assertTrue(qPage.isQPageDisplayed("Q1"));
        qPage.submitForm("5", "3", "8");

        assertTrue(qPage.isQPageDisplayed("Q2"));
        
    }

    @Test
    public void testInvalidSubmissionQ1Page() {
        driver.get(BASE_URL + LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoginPageDisplayed());

        loginPage.submitLoginForm(username, password, dob);

        QuestionPage qPage = new QuestionPage(driver);
        assertTrue(qPage.isQPageDisplayed("Q1"));
        qPage.submitForm("1", "2", "1");

        assertTrue(qPage.checkError());
        assertTrue(qPage.isQPageDisplayed("Q1"));

    }

    @Test
	public void testEmptyNumber1AndNumber2Q2Page() {
    	testValidSubmissionQ1Page();
    	  QuestionPage qPage = new QuestionPage(driver);
          assertTrue(qPage.isQPageDisplayed("Q2"));
          
          qPage.submitForm("", "", "");

		 assertTrue(qPage.checkError());
	     assertTrue(qPage.isQPageDisplayed("Q2"));
		
	}
    
    @Test
    public void testValidSubmissionQ2Page() {
    	testValidSubmissionQ1Page();

        QuestionPage qPage = new QuestionPage(driver);
        assertTrue(qPage.isQPageDisplayed("Q2"));
        qPage.submitForm("5", "3", "2");

        assertTrue(qPage.isQPageDisplayed("Q3"));
        
    }
    
    @Test
    public void testInvalidSubmissionQ2Page() {
    	testValidSubmissionQ1Page();

        QuestionPage qPage = new QuestionPage(driver);
        assertTrue(qPage.isQPageDisplayed("Q2"));
        qPage.submitForm("1", "2", "1");

        assertTrue(qPage.checkError());
        assertTrue(qPage.isQPageDisplayed("Q2"));

    }
    
    @Test
   	public void testEmptyNumber1AndNumber2Q3Page() {
    	testValidSubmissionQ2Page();
       	  QuestionPage qPage = new QuestionPage(driver);
             assertTrue(qPage.isQPageDisplayed("Q3"));
             
             qPage.submitForm("", "", "");

   		 assertTrue(qPage.checkError());
   	     assertTrue(qPage.isQPageDisplayed("Q3"));
   		
   	}
    @Test
    public void testValidSubmissionQ3Page() {
    	testValidSubmissionQ2Page();
     	  QuestionPage qPage = new QuestionPage(driver);
           assertTrue(qPage.isQPageDisplayed("Q3"));
           
           qPage.submitForm("1", "1", "2");

       SuccessPage sPage = new SuccessPage(driver);
       Assert.assertTrue(sPage.isCongratulationsPageDisplayed());
        
    }
    
    @Test
   	public void testInvalidSubmissionQ3Page() {
    	testValidSubmissionQ2Page();
       	  QuestionPage qPage = new QuestionPage(driver);
             assertTrue(qPage.isQPageDisplayed("Q3"));
             
             qPage.submitForm("1", "2", "1");

   		 assertTrue(qPage.checkError());
   	     assertTrue(qPage.isQPageDisplayed("Q3"));
   		
   	}
   
    
	@After
	public void tearDown() {
		//driver.quit();
	}

}
