package steps;

import net.thucydides.core.annotations.Step;
import pages.homePage;
import pages.searchResultsPage;

public class JBHifiSteps {
	homePage homePg;
	searchResultsPage searchResultsPg;
	
	@Step("Navigate to jbhifi.com.au website home page")
	public JBHifiSteps navigate() {
		homePg.open();
		return this;
	}
	
	@Step("Click on Search Products,brands and more...")
	public void clickSearchProducts() {
		homePg.clickSearchProducts();
	}
	
	@Step("Search Products")
	public void searchForProduct(String Product) {
		homePg.SearchProduct(Product);
	}
	
	@Step("Submit Search Criteria")
	public void searchProducts() {
		homePg.submitSearchCriteria();
	}
	
	@Step("Click on Brand list")
	public void clickBrandList() {
		searchResultsPg.clickBrand();
	}
	
	@Step("Click on Price list")
	public void clickPriceList() {
		searchResultsPg.clickPrice();
	}
	
	@Step("Select Brand by Name")
	public void selectBrand(String BrandName) {
		searchResultsPg.selectBrand(BrandName);
	}
	
	@Step("Click show results after Brand selection")
	public void ShowResultsByBrand() {
		searchResultsPg.clickShowResults_Brand();
	}
	
	@Step("Enter minimum and maximum price")
	public void enterMinMaxPriceRange(String minPrice,String maxPrice) {
		searchResultsPg.enterMinPrice(minPrice);
		searchResultsPg.enterMaxPrice(maxPrice);
	}
	
	@Step("Sort Results by price")
	public void sortResultsByPrice(String sortValue)
	{
		searchResultsPg.sortResultsBy(sortValue);
	}
	
	@Step("Get Product Header")
	public String getProductHeader(int resultIterator) {
		return searchResultsPg.getProductResultHeader(resultIterator);
	}
	
	@Step("Get Product Price")
	public String getProductPrice(int resultIterator) {
		return searchResultsPg.getProductResultPrice(resultIterator).replace("$", "");
	}
	
	@Step("Add Product to Cart")
	public void addProductToCart(int resultIterator) {
		searchResultsPg.clickAddToCart(resultIterator);
	}
	
	@Step("Click on cart")
	public void clickOnShoppingCart() {
		searchResultsPg.clickShoppingCart();
	}
	
	@Step("Verify shopping cart item")
	public boolean checkShoppingCartItem(String cartItem) {
		return searchResultsPg.verifyCartItem(cartItem);
	}
	
	@Step("Retrieve current page URL")
	public String getCurrentURL() {
		return homePg.getCurrentPageURL();
	}
}
