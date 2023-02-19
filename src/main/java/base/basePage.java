package base;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class basePage extends PageObject {
	
	/**Common libraries**/	
	
	//Get current page URL
	public String getCurrentPageURL() {
		return getDriver().getCurrentUrl();
	}
	
	//Get WebElement with Locator as input(xpath, css, link, name, id)
	public WebElementFacade getElement(String Locator) {
		try {
			return find(getBy(Locator));
		}catch(Exception e)
		{
			e.getMessage();
		}
		return null;
	}
	
	//Get WebElement list with Locator as input(xpath, css, link, name, id)
	public List<WebElementFacade> getElements(String Locator){
		try {
			return findAll(getBy(Locator));
		}catch(NoSuchElementException e) {
			e.getMessage();
			return null;
		}
	}
	
	//Select WebElement based on value
	public void selectElement(String Locator,String selectVal) {
		waitFor(getElement(Locator)).selectByVisibleText(selectVal);
	}
	
	//click on WebElement with locator as input(xpath, css, link, name, id)
	public void click(String Locator)
	{
		waitFor(getElement(Locator)).click();
	}
	
	//Type text into WebElement with locator as input(xpath, css, link, name, id)
	public void type(String Locator,String value)
	{
		waitFor(getElement(Locator)).clear();
		waitFor(getElement(Locator)).sendKeys(value);
	}
	
	//Type text and Enter on WebElement with locator(xpath, css, link, name, id) and value as inputs
	public void EnterText(String Locator,String value) {
		WebElementFacade element = waitFor(getElement(Locator));
		element.click();
		element.clear();
		element.typeAndEnter(value);
	}
	
	//Get Text of a WebElement
	public String getText(String Locator) {
		return waitFor(getElement(Locator)).getText();
	}
	
	//Get a WebElement attribute with locator(xpath, css, link, name, id) and AttributeType(class, id, etc.,)
	public String getAttribute(String Locator,String AttributeType) {
		return waitFor(getElement(Locator)).getAttribute(AttributeType).toString();
	}
	
	//Focus on a WebElement
	public void moveMouseTo(String Locator) {
	  WebElement moveTo = waitFor(getElement(Locator));
	  withAction().moveToElement(moveTo).perform();
	}
	
	//Get WebElement
	private By getBy(String locator) {
		By by=null;
		try {
			if(locator.startsWith("id=")) {
				locator = locator.substring(3);
				by=by.id(locator);
			}else if(locator.startsWith("xpath=")) {
				locator = locator.substring(6);
				by=by.xpath(locator);
			}else if(locator.startsWith("css=")) {
				locator = locator.substring(4);
				by = by.cssSelector(locator);
			}else if(locator.startsWith("name=")) {
				locator = locator.substring(5);
				by = by.name(locator);
			}else if(locator.startsWith("link=")) {
				locator = locator.substring(5);
				by = by.linkText(locator);
			}
			 return by;
		}catch(Throwable t)
		{
			t.getMessage();
		}
		return null;
	}	
}