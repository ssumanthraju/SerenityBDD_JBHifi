#PreRequisites
1. Minimum jdk version required is 1.8
2. chromedriver.exe version 109.0.5414.74 required for execution.
3. geckodriver.exe version 0.32.2 required for execution.

##Steps to Execute
1. Enter Browser input in "serenity.conf" in the below path. (Only Firefox and Chrome browsers selected for execution)
	a. src/test/resources/serenity.conf
	b. For chrome, Specify input as "driver = chrome"
	c. For firefox, Specify input as "driver = firefox"
2. Run "Execute.bat" file present in the root folder.
3. Alternatively,
	a. Import project into Eclipse IDE.
	b. Once Successfully loaded and dependencies of pom.xml successfully imported, 
	   Open pom.xml->Run as Maven build (clean verify serenity:aggregate)
	
###TestData
1. Feature file with 2 Scenario outlines is in the below path.
	a. src/test/resources/features/AddProductToShoppingCart.feature
2. Configure Examples of 2 Scenario outlines with below input parameters.
	a. brand, minPrice, maxPrice, sortPriceRange, item

####Test Execution Results
1. Serenity Test Executon Reports can be seen in the below path.
	a. target/site/serenity/index.html
	