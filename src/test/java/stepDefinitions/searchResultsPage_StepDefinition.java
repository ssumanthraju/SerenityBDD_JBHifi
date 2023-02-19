package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import steps.JBHifiSteps;

public class searchResultsPage_StepDefinition {
	String productName;
	@Steps
	JBHifiSteps jbhifi;
	@Then("^validate printer item (.+) price is less than (.+)$")
    public void validate_printer_item_price_is_less_than(String item, String maxprice) throws Throwable {
		productName = jbhifi.getProductHeader(Integer.parseInt(item));
		Assert.assertTrue("Validate if Item:"+item+" is less than "+maxprice,
        			Integer.parseInt(jbhifi.getProductPrice(Integer.parseInt(item)))<(Integer.parseInt(maxprice)));
    }

    @And("^user filters brand by (.+)$")
    public void user_filters_brand_by(String brand) throws Throwable {
        jbhifi.clickBrandList();
        jbhifi.selectBrand(brand);
    }

    @And("^user filters price range between (.+) and (.+)$")
    public void user_filters_price_range_between_and(String minprice, String maxprice) throws Throwable {
    	jbhifi.clickPriceList();
    	jbhifi.enterMinMaxPriceRange(minprice, maxprice);
    }

    @And("^user sorts price from (.+)$")
    public void user_sorts_price_from(String sortpricerange) throws Throwable {
    	jbhifi.sortResultsByPrice(sortpricerange);
    }

    @And("^user adds printer item (.+) to cart from search results$")
    public void user_adds_printer_item_to_cart_from_search_results(String item) throws Throwable {
    	productName = jbhifi.getProductHeader(Integer.parseInt(item));
    	jbhifi.addProductToCart(Integer.parseInt(item));
    }

    @And("^validate printer item (.+) contains text (.+)$")
    public void validate_printer_item_contains_text(String item, String brand) throws Throwable {
        Assert.assertTrue("Validate if Item:"+item+" is of brand:"+brand,
        		productName.toLowerCase().contains(brand.toLowerCase()));
    }

    @And("^validate printer item successfully added to cart$")
    public void validate_printer_item_successfully_added_to_cart() throws Throwable {
    	jbhifi.clickOnShoppingCart();
    	Assert.assertTrue(jbhifi.checkShoppingCartItem(productName));
        
    }
}
