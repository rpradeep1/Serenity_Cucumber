package project.feature.steps.definitions;

import org.junit.Assert;
import org.openqa.selenium.Dimension;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;
import project.pageobjects.CPTICDLINKMyTasksPage;
import project.utilities.DBQueries;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class cpticdlinkdefs extends ScenarioSteps {
	
	private static final long serialVersionUID = 5898280540796957114L;

	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(cpticdlinkdefs.class);

	LoginPage ologinPage;
	HomePage oHomePage;
	CPTICDLINKMyTasksPage oCPTICDLINKMyTasksPage;
	SeleniumUtils oSeleniumUtils;
	DBQueries oDBQueries;
	
	@Step
	public void loginCPTICDLink(String sUserName) {
		ologinPage.open();
		logger.info("JBPM Home page opened successfully");
		Assert.assertTrue("JBPM Home page should be dispalyed.", ologinPage.loginToCPTICDLink(sUserName));
	}
	
	@Step
	public void ClickCPTICDLink() {
		
		oSeleniumUtils.highlightElement(oHomePage.CPTICDLink);
		oHomePage.CPTICDLink.click();
		logger.info("CPT ICD LINK is clicked successfully");
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		
	}
	
	@Step
	public void CPTICDLINKMYTasks() {
		
		
		oSeleniumUtils.switchWindowUsingWindowCount(5, 2);
		oSeleniumUtils.highlightElement(oCPTICDLINKMyTasksPage.Request_LCD_Article_For_Review_Btn);
		boolean sVal = oSeleniumUtils.is_WebElement_Displayed(oCPTICDLINKMyTasksPage.Request_LCD_Article_For_Review_Btn);
		
		if (sVal) {
			
			logger.info("CPT ICD LINK My Tasks Page is displayed successfully");
		}
		
		
		oSeleniumUtils.highlightElement(oCPTICDLINKMyTasksPage.GroupTasks_Btn);
		oSeleniumUtils.Click_given_WebElement(oCPTICDLINKMyTasksPage.GroupTasks_Btn);
		logger.info("Group Tasks Button is clicked successfully");
		
		oSeleniumUtils.waitFor(oCPTICDLINKMyTasksPage.LCD_Article_List_Box);
		oSeleniumUtils.highlightElement(oCPTICDLINKMyTasksPage.LCD_Article_List_Box);
		oSeleniumUtils.Click_given_WebElement(oCPTICDLINKMyTasksPage.LCD_Article_List_Box);
		logger.info("LCD Article List Box is clicked successfully");
		oSeleniumUtils.waitFor(oCPTICDLINKMyTasksPage.LCD_Check_Box);
		
		oSeleniumUtils.highlightElement(oCPTICDLINKMyTasksPage.LCD_Check_Box);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.Click_given_WebElement(oCPTICDLINKMyTasksPage.LCD_Check_Box);		
		logger.info("LCD Check Box is clicked successfully");
		
		
		oSeleniumUtils.highlightElement(oCPTICDLINKMyTasksPage.Article_Check_Box);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.Click_given_WebElement(oCPTICDLINKMyTasksPage.Article_Check_Box);		
		logger.info("Article Check Box is clicked successfully");
		
		
		oSeleniumUtils.Click_given_WebElement(oCPTICDLINKMyTasksPage.CPT_ICD_Link_HomePage);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		
		oCPTICDLINKMyTasksPage.IndividualTasks_Btn.click();
		
		oSeleniumUtils.waitFor(oCPTICDLINKMyTasksPage.LCD_Article_List_Box);
		oSeleniumUtils.highlightElement(oCPTICDLINKMyTasksPage.LCD_Article_List_Box);
		oSeleniumUtils.Click_given_WebElement(oCPTICDLINKMyTasksPage.LCD_Article_List_Box);
		logger.info("LCD Article List Box is clicked successfully");
		oSeleniumUtils.waitFor(oCPTICDLINKMyTasksPage.LCD_Check_Box);
		
		oSeleniumUtils.highlightElement(oCPTICDLINKMyTasksPage.LCD_Check_Box);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.Click_given_WebElement(oCPTICDLINKMyTasksPage.LCD_Check_Box);		
		logger.info("LCD Check Box is clicked successfully");
		
		
		/*oSeleniumUtils.highlightElement(oCPTICDLINKMyTasksPage.Article_Check_Box);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.Click_given_WebElement(oCPTICDLINKMyTasksPage.Article_Check_Box);		
		logger.info("Article Check Box is clicked successfully");*/
		
		oSeleniumUtils.Click_given_WebElement(oCPTICDLINKMyTasksPage.CPT_ICD_Link_HomePage);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		
		String elements = oCPTICDLINKMyTasksPage.LCD_Val;
		int cnt = elements.length();
		logger.info("LCD Cnt --> " + cnt);
		
		
		
		
	}


}
