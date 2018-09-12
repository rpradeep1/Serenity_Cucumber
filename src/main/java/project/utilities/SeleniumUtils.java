package project.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class SeleniumUtils extends PageObject {
	
	public void waitUntillGivenWindowPresent(int Time, int NoofWindows) {

		Set<String> windows = getDriver().getWindowHandles();
		int windowCount = windows.size();
		System.out.println("Windows Count" + windows.size());
		for (int i = 0; i <= Time; i++) {

			if (windowCount >= NoofWindows) {
				break;
			} else {
				try {
					System.out.println("Window called");
					defaultWait(2000);
				} catch (Exception e1) {
					System.out.println("Waiting for webelement in DOM");
				}

			}
		}

	}

	public void switchWindowUsingWindowCount(int waitTimer, int windowNum) {

		waitUntillGivenWindowPresent(waitTimer, windowNum);
		ArrayList<String> windowHandles = new ArrayList<String>(getDriver().getWindowHandles());
		System.out.println("WINDOWS" + windowHandles.size());
		getDriver().switchTo().window(windowHandles.get(windowNum - 1).toString());

	}

	public static void defaultWait(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public static String getValueByName(String Name) {
		
		return Serenity.sessionVariableCalled(Name).toString();
	}

	public String getLastWebelemtFromList(String xpath) {
		
		List<WebElement> list = getDriver().findElements(By.xpath(xpath));
		int size = list.size();
		System.out.println(size);
		return list.get(size - 1).getText();
	}
	
	public void switchToNewWindow() {

		String baseWindowHandle = getDriver().getWindowHandle();
		Set<String> openedWindows = getDriver().getWindowHandles();
		String newWindow = null;
		if (openedWindows.size() > 1 && openedWindows.remove(baseWindowHandle)) {
			Iterator<String> openedWindowsIterator = openedWindows.iterator();
			newWindow = (String) openedWindowsIterator.next();
		}
		getDriver().switchTo().window(newWindow);
	}
public void moveToElement(String xpath){
		
		WebElement element = getDriver().findElement(By.xpath(xpath));
		Actions builder = new Actions(getDriver());
        builder.moveToElement(element).build().perform();
      
	}
	public WebElement waitUnitillGivenElementPresent(String Xpath, int Time) {
		
		WebElement element = null;
		try {

			for (int i = 0; i < Time; i++) {
				try {
					element = getDriver().findElement(By.xpath(Xpath));
					break;
				} catch (Exception e) {
					try {
						defaultWait(2000);
					} catch (Exception e1) {
						System.out.println("Waiting for webelement in DOM");
					}

				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("in wait until complete page load" + element.isDisplayed());

		}
		return element;
	}
	
	public void SwitchToFrame(String sFrame) {		
		WebElement element = getDriver().findElement(By.xpath(sFrame));		
		getDriver().switchTo().frame(element);		
	}
	
	public boolean is_WebElement_Displayed(WebElementFacade element) {
		highlightElement(element);
		return element.withTimeoutOf(ProjectVariables.MAX_TIME_OUT, TimeUnit.SECONDS).isDisplayed();
	}
	
	public boolean is_WebElement_Displayed(String xpath) {
		highlightElement(xpath);
		return $(xpath).withTimeoutOf(ProjectVariables.MAX_TIME_OUT, TimeUnit.SECONDS).isDisplayed();
	}

	public void Click_given_Locator(String xpath) {
		highlightElement(xpath);
		$(xpath).withTimeoutOf(ProjectVariables.MAX_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().click();
	}
	
	public void highlightElement(String Xpath) {

		WebElement element = getDriver().findElement(By.xpath(Xpath));
		for (int i = 0; i < ProjectVariables.HIGHLIGHT_COUNT; i++) {
			WebDriver driver = getDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: black; border: 6px solid black;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}

	}
	
	public static void scrollingToGivenElement(WebDriver driver,String xpath) {
		
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scrollingToGivenElement(WebDriver driver,WebElement element) {		
		
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);
	}
		
	public void highlightElement(WebElement element) {

		for (int i = 0; i < ProjectVariables.HIGHLIGHT_COUNT; i++) {
			WebDriver driver = getDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: black; border: 6px solid black;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}

	}
	
	public void Click_given_WebElement(WebElementFacade element) {
		highlightElement(element);
		element.withTimeoutOf(ProjectVariables.MIN_SLEEP, TimeUnit.SECONDS).waitUntilVisible().click();
	}
	
	public void select_Given_Value_From_DropDown(WebElement element, String sValue) {		
		
		highlightElement(element);
		
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(sValue);
	}
	
	public void select_Given_Value_From_DropDown(String xpath, String sValue) {		
		
		highlightElement(xpath);
		
		Select dropDown = new Select(getDriver().findElement(By.xpath(xpath)));
		dropDown.selectByVisibleText(sValue);
	}
	
	public String get_FirstSelected_Option_In_DropDown(WebElement element) {			
		highlightElement(element);	
		Select dropDown = new Select(element);
		return dropDown.getFirstSelectedOption().getText();
		 
	}
	
	public void enter_given_text_webelement(WebElementFacade element, String text) {
		
		element.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().clear();
		element.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().sendKeys(text);

	}
	
	public String get_Text_From_WebElement(WebElementFacade element) {

		highlightElement(element);
		return element.withTimeoutOf(ProjectVariables.MAX_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().getTextValue();
	} 
 
	public String get_TextFrom_Locator(String Xpath) {
		highlightElement(Xpath);
		return $(Xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible()
				.getTextValue().trim();

	}
	
	public String get_AttributeValueFrom_Locator(String Xpath,String Attribute) {
		return $(Xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().getAttribute(Attribute).trim();
	}
	
	public void enter_given_text_StringLocator(String element, String text) {
			
			$(element).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().clear();
			$(element).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().sendKeys(text);

		}
	
	public void clear_Text(String element){
		$(element).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().clear();
	}
	
	public int getMatchingXpathCount(String xpath) {
		
		List<WebElement> list = getDriver().findElements(By.xpath(xpath));
		int size = list.size();
		System.out.println(size);
		return size;
	}
	
	public ArrayList<String> getDropDownValues(String xpath){
		
		ArrayList<String> list = new ArrayList<String>();
		WebElement element = getDriver().findElement(By.xpath(xpath));		
		Select select = new Select(element);
		System.out.println("Drop down itmes count:- "+select.getOptions().size());
		for(int iLoop = 1; iLoop < select.getOptions().size(); iLoop++){			
			String sLocatorValue = select.getOptions().get(iLoop).getText();
			System.out.println(sLocatorValue);
			list.add(sLocatorValue);
		}		
		return list;
		
	}

	public boolean is_WebElement_Present(String Xpath) {
		try {
			return $(Xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).isPresent();
		} catch (Exception e) {
			return false;
		}

	}
}

