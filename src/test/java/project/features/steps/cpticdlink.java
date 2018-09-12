package project.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.cpticdlinkdefs;

public class cpticdlink {
	
	@Steps
	cpticdlinkdefs cpticdlinkdefs;
	
	

	
	@Given("^User logs with \"([^\"]*)\" as CPT ICD RA into JBPM Application$")
	public void user_logs_with_as_CPT_ICD_RA_into_JBPM_Application(String sUserName) throws Throwable {
		
		cpticdlinkdefs.loginCPTICDLink(sUserName);

	}

	@When("^RA clicks on CPT ICD Link in My Tasks$")
	public void ra_clicks_on_CPT_ICD_Link_in_My_Tasks() throws Throwable {
	
	}

	@When("^RA clicks on \"([^\"]*)\" Task Tab$")
	public void ra_clicks_on_Task_Tab(String arg1) throws Throwable {

	}

	@When("^RA claims \"([^\"]*)\" code from group Tasks$")
	public void ra_claims_code_from_group_Tasks(String arg1) throws Throwable {
	
	}

	@When("^RA clicks on claimed \"([^\"]*)\"$")
	public void ra_clicks_on_claimed(String arg1) throws Throwable {

	}

	@Then("^RA Review Work Queue screen should be displayed$")
	public void ra_Review_Work_Queue_screen_should_be_displayed() throws Throwable {

	}

	@Then("^Review status should be dispalyed as \"([^\"]*)\"$")
	public void review_status_should_be_dispalyed_as(String arg1) throws Throwable {

	}

	@When("^RA clicks on \"([^\"]*)\"$")
	public void ra_clicks_on(String arg1) throws Throwable {

	}

	@When("^RA enters the remarks as \"([^\"]*)\" for the rejected codes$")
	public void ra_enters_the_remarks_as_for_the_rejected_codes(String arg1) throws Throwable {

	}

	@Then("^RA should be able to view the filter codes based on \"([^\"]*)\"$")
	public void ra_should_be_able_to_view_the_filter_codes_based_on(String arg1) throws Throwable {

	}

	@Then("^Remarks column should be sorted$")
	public void remarks_column_should_be_sorted() throws Throwable {

	}

	@Then("^Logout of the Application$")
	public void logout_of_the_Application() throws Throwable {

	}



}
