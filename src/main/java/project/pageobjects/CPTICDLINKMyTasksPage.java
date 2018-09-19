package project.pageobjects;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CPTICDLINKMyTasksPage extends PageObject {
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn-primary Request LCD/Article for Review pull-right']")
	public WebElementFacade Request_LCD_Article_For_Review_Btn;	
	
	@FindBy(xpath = "//a[contains(text(), 'Group')]")
	public WebElementFacade GroupTasks_Btn;
	
	@FindBy(xpath = "//div[@id='dropdownlistContentlcdOrArticle']")
	public WebElementFacade LCD_Article_List_Box;
	
	@FindBy (xpath = "//div/div[1][@id='listitem0innerListBoxlcdOrArticle']/span[contains(text(),'LCD')]")
	public WebElementFacade LCD_Check_Box;
	
	@FindBy (xpath = "//div/div[@id='listitem1innerListBoxlcdOrArticle']/span[contains(text(),'Article')]")
	public WebElementFacade Article_Check_Box;
	
	@FindBy (xpath = "//h1[contains(text(),'CPT ICD Link')]")
	public WebElementFacade CPT_ICD_Link_HomePage;
	
	@FindBy (xpath = "//li/a[contains(text(),'Individual')]")
	public WebElementFacade IndividualTasks_Btn;
	
	@FindBy (xpath = "//div[@id='dropdownlistWrapperngxDropDownList3']")
	public WebElementFacade Status_List_Box;
	
	@FindBy (xpath = "//div[contains(text(),'LCD')]")
	public WebElementFacade LCD_Element;
	
	public String LCD_Val = "//div[contains(text(),'LCD')]";
	
	
	
	
	

}
