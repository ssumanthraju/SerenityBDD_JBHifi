Feature: User navigates to site and adds printer to shopping cart
As a user I want to add printer to shopping cart

Background:
Given user navigate to the website

@SmokeTest
Scenario Outline: Validate printer search results is of correct brand selected and is within price range
Given user is on the Home Page
When user search for "printer" in Home Page
And user filters brand by <brand>
And user filters price range between <minPrice> and <maxPrice>
And user sorts price from <sortPriceRange>
Then validate printer item <item> price is less than <maxPrice>
And validate printer item <item> contains text <brand>
Examples:
|brand|minPrice|maxPrice|sortPriceRange|item|
|Canon|100|300|Price: Low - High|1|

@SmokeTest
Scenario Outline: Add printer to shopping cart
Given user is on the Home Page
When user search for "printer" in Home Page
And user filters brand by <brand>
And user filters price range between <minPrice> and <maxPrice>
And user sorts price from <sortPriceRange>
And user adds printer item <item> to cart from search results
Then validate printer item successfully added to cart
Examples:
|brand|minPrice|maxPrice|sortPriceRange|item|
|Canon|100|300|Price: Low - High|1|