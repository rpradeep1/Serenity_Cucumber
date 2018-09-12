package project.feature.steps.definitions;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;

import project.utilities.DBQueries;
import project.utilities.SeleniumUtils;

public class cpticdlinkdefs extends ScenarioSteps {
	
	private static final long serialVersionUID = 5898280540796957114L;

	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(cpticdlinkdefs.class);

	LoginPage ologinPage;
	HomePage oHomePage;
	SeleniumUtils oSeleniumUtils;
	DBQueries oDBQueries;
	
	@Step
	public void loginCPTICDLink(String sUserName) {
		ologinPage.open();
		logger.info("JBPM Home page opened successfully");
		Assert.assertTrue("JBPM Home page should be dispalyed.", ologinPage.loginToCPTICDLink(sUserName));
	}
	
	

}
