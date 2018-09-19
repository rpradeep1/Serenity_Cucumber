package project.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import project.utilities.GenericUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class JBPMLoginPage extends PageObject {
	
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginPage.class);
	
	SeleniumUtils oSeleniumUtils ;
	
	@FindBy(xpath = "//label[text()='User Name :']/../following-sibling::td//input")
	public WebElementFacade UserName_Txt;
	
	@FindBy(xpath = "//label[text()='Password :']/../following-sibling::td//input")
	public WebElementFacade Password_Txt;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElementFacade Login_Btn;
	
	@FindBy(xpath = "//a[text()='Task Management']")
	public WebElementFacade JBPMHomePage;
	
	
	@WhenPageOpens
	public void LoginPageValidation() {
		
		UserName_Txt.waitUntilVisible();
		
	}
	
	
	public boolean loginJBPM(String UserName) {		
		
		getDriver().manage().window().maximize();
		
		
	    //Enter User name
			oSeleniumUtils.highlightElement(UserName_Txt);
			UserName_Txt.clear();
			UserName_Txt.sendKeys(UserName);
			logger.info("User Name entered successfully :"+UserName);
			
			//Enter Password
			oSeleniumUtils.highlightElement(Password_Txt);        
			Password_Txt.clear();
			String sPassword = GenericUtils.decode(ProjectVariables.PASSWORD);
			Password_Txt.sendKeys(sPassword);
			logger.info("Password entered successfully");
			
			oSeleniumUtils.Click_given_WebElement(Login_Btn);
			logger.info("Login Button clicked successfully.");
		
		
		return JBPMHomePage.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().isDisplayed();
		
	}
	
	
	
	

}
