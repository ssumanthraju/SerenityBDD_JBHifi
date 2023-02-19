package pages;

import base.basePage;

public class homePage extends basePage {
	
	//Page Objects
	String searchBox = "css=input[placeholder='Search products, brands, and more...']";
	String searchBoxAfterClick = "css=.input-search";
	String submitSearch = "css=.submit-search";
	
	//Click on Search Products Edit Box
	public searchResultsPage clickSearchProducts() {
		click(searchBox);
		return new searchResultsPage();
	}
	
	//Type into updated Search box
	public void SearchProduct(String Product) {
		type(searchBoxAfterClick, Product);
	}
	
	//Submit Search Criteria
	public void submitSearchCriteria() {
		click(submitSearch);
	}
}
