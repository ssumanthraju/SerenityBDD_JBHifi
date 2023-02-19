package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.basePage;
import net.serenitybdd.core.pages.WebElementFacade;

public class searchResultsPage extends basePage {
	
	//Page Objects
	String brand = "xpath=//button[@class='search-results-facet-button' and contains(text(),'Brand')]";
	String brands = "xpath=//ul[@class='ais-RefinementList-list']/li[@class='ais-RefinementList-item']/label/input";
	String brandShowResults = "xpath=//span[contains(text(),'Show results')]/ancestor::div/button[contains(text(),'Brand')]";
	String price = "xpath=//button[@class='search-results-facet-button' and contains(text(),'Price')]";
	String minPrice = "css=#min-input";
	String maxPrice = "css=#max-input";
	String resultsSortBy = "xpath=//select";
	String brandResultsLst = "xpath=//*[@class='search-results-loop']/div";
	String shoppingCart = "css=#minicart-toggle";
	String shoppingCartLst = "xpath=//*[@class='cart-mini__content']/div";
	
	//click Brand list
	public void clickBrand() {
		click(brand);
	}
	
	//click Price list
	public void clickPrice() {
		click(price);
	}
	
	//enter Minimum Price Range
	public void enterMinPrice(String minPriceValue) {
		EnterText(minPrice, minPriceValue);
	}
	
	//enter Maximum Price Range
	public void enterMaxPrice(String maxPriceValue) {
		EnterText(maxPrice,maxPriceValue);
	}
	
	//sort Relevancy based on sortType (low-high, high-low etc.,)
	public void sortResultsBy(String sortVal)
	{
		selectElement(resultsSortBy, sortVal);
	}
	
	//Select Brand with brandName as input
	public void selectBrand(String brandName) {
		List<WebElementFacade> brandsList  = getElements(brands);		
		for(WebElementFacade webElementBrand:brandsList) {
			if(waitFor(webElementBrand).getAttribute("name").equalsIgnoreCase(brandName))
			{
				webElementBrand.click();
				break;
			}
		}
	}
	
	//Get the nth (1,2,3...) WebElement and fetch Header child element
	public String getProductResultHeader(int resultItemIterator) {
		
		List<WebElementFacade> ResultsLst = getElements(brandResultsLst);
		String returnProductHeader;
		for(int i=0;i<ResultsLst.size();i++)
		{
			if(i==resultItemIterator-1)
			{
				returnProductHeader = (ResultsLst.get(i).thenFindAll(By.tagName("h4")).get(0).getText());
				return returnProductHeader;
			}
		}
		return null;
	}
	
	//Get the nth (1,2,3....) WebElement and fetch Price child element
	public String getProductResultPrice(int resultItemIterator) {
		
		List<WebElementFacade> ResultsLst = getElements(brandResultsLst);
		List<WebElementFacade> ResultsPriceLst;
		for(int i=0;i<ResultsLst.size();i++)
		{
			if(i==resultItemIterator-1)
			{
				ResultsPriceLst = ResultsLst.get(i).thenFindAll(By.tagName("span"));
				for(int k=0;k<ResultsPriceLst.size();k++) {
					if(ResultsPriceLst.get(k).getAttribute("class").equals("ais-hit--price price")) {
						return ResultsPriceLst.get(k).getTextContent();
					}
				}
			}
		}
		return null;
	}
	
	//Get the nth (1,2,3....) WebElement and click on "AddToCart" child element
	public void clickAddToCart(int resultItemIterator) {
		List<WebElementFacade> ResultsLst = getElements(brandResultsLst);
		List<WebElementFacade> ResultsButtonLst;
		for(int i=0;i<ResultsLst.size();i++) {
			if(i==resultItemIterator-1)
			{
				ResultsButtonLst = ResultsLst.get(i).thenFindAll(By.tagName("button"));
				for(WebElement objButton:ResultsButtonLst) {
					if(objButton.getAttribute("class").equals("ais-hit--cart-button cart-button__add"))
					{
						objButton.click();
						break;
					}	
				}
			}
		}
	}
	
	//Click on ShowResults button
	public void clickShowResults_Brand() {
		click(brandShowResults);
	}
	
	//click on cart at top left section of Page
	public void clickShoppingCart() {
		click(shoppingCart);
	}
	
	//Verify if an item is available in Cart
	public boolean verifyCartItem(String cartItem) {
		
		List<WebElementFacade> cartItemsLst = getElements(shoppingCartLst);
		List<WebElementFacade> cartItemNames;
		for(int i=0;i<cartItemsLst.size();i++) {
			cartItemNames = cartItemsLst.get(i).thenFindAll(By.tagName("h6"));
			for(WebElement ocartName:cartItemNames) {
				if(ocartName.getText().trim().equals(cartItem))
					return true;
			}
		}
		return false;
	}
}