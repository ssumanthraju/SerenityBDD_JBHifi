package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.SerenitySystemProperties;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import pages.homePage;
import steps.JBHifiSteps;

public class homePage_StepDefinition {
	
	@Steps
	JBHifiSteps jbhifi;
	
	@Given("^user is on the Home Page$")
    public void user_is_on_the_home_page() throws Throwable {		
       EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();       
       Assert.assertEquals(jbhifi.getCurrentURL(),variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL));
    }

    @When("^user search for \"([^\"]*)\" in Home Page$")
    public void user_search_for_something_in_home_page(String productType) throws Throwable {
        jbhifi.clickSearchProducts();
    	jbhifi.searchForProduct(productType);
    	jbhifi.searchProducts();
    }
    @Given("^user navigate to the website$")
    public void user_navigate_to_the_website() throws Throwable {
        jbhifi.navigate();
    }
}