package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import helper.FileReaderManager;
import helper.PageObjectManager;
import io.cucumber.java.en.*;
import pomClass.LoginPage;
import runner.Runner;

public class StepDefinition extends BaseClass {
	
	public static WebDriver driver = Runner.driver;
	PageObjectManager pom = new PageObjectManager(driver);
	
	@Given("user launch the application")
	public void userLaunchTheApplication() throws IOException {
	
		getUrl(FileReaderManager.getInstance().getCrInstance().getURL());
		
	}

	@Given("user logins as {string} with {string}")
	public void userLoginsAsWith(String name, String password) {
		
		sendKeys(pom.getlp().getUserName(), name);
		sendKeys(pom.getlp().getPassword(), password);
		click(pom.getlp().getSignIn());
	}

	@Given("user clicks on menu")
	public void userClicksOnMenu() {
		click(pom.getProductsPage().getMenu());
	}

	@When("user clicks on about")
	public void userClicksOnAbout() {
		
		WebElement about = pom.getProductsPage().getAbout();
		explicitVisibilityOfWebElement(10, about);
		click(about);
	}

	@Then("user verfiy the url navigates to saucelabs")
	public void userVerfiyTheUrlNavigatesToSaucelabs() throws IOException {
		
		String currentURL = getCurrentURL();
		String labsURL = FileReaderManager.getInstance().getCrInstance().getLabsURL();
		assertEquals(labsURL, currentURL);
	}

	@Then("user navigates back to products page and verifies")
	public void userNavigatesBackToProductsPageAndVerifies() throws IOException {
		
		navigateBack();
		String productPageHeader = getText(pom.getProductsPage().getHeader());
		String header = FileReaderManager.getInstance().getCrInstance().productHeader();
		assertEquals(header, productPageHeader);
	}

	@Given("user adds highest product price")
	public void userAddsHighestProductPrice() {
		
		
		List<WebElement> price = pom.getProductsPage().getPrice();
		List<WebElement> cartButton = pom.getProductsPage().getAddToCart();
		double highestPrice = 0;
		int a = 0;
		for (int i = 0; i < price.size(); i++) {
			
			String am = price.get(i).getText().split("\\$")[1];
			double z  = Double.parseDouble(am);
			if(z > highestPrice) {
				highestPrice = z ;
				if(i>a) {
					a=i;
						
			}
		}
	}
		cartButton.get(a).click();
	}

	@When("user goes to cart page")
	public void userGoesToCartPage() {
		click(pom.getProductsPage().getGoToCart());
	}

	@When("verfiy the cart page")
	public void verfiyTheCartPage() throws IOException {
		
		String cartPageHeader = getText(pom.cartPage().getHeader());
		String cpHeader = FileReaderManager.getInstance().getCrInstance().cartHeader();
		assertEquals(cpHeader, cartPageHeader);
	}

	@Then("user checkouts and validates")
	public void userCheckoutsAndValidates() throws IOException {
		
		click(pom.cartPage().getCheckout());
		String checkoutHeader = getText(pom.checkout().getHeader());
		String coHeader = FileReaderManager.getInstance().getCrInstance().checkOutHeader();
		assertEquals(coHeader, checkoutHeader);
	}

	@Given("user enters {string} in firstname and {string} in lastname")
	public void userEntersInFirstnameAndInLastname(String firstName, String lastName) {
		
		sendKeys(pom.checkout().getFirstName(), firstName);
		sendKeys(pom.checkout().getLastName(), lastName);
	}

	@Given("user enters {string} as pincode")
	public void userEntersAsPincode(String pincode) {
		sendKeys(pom.checkout().getPinCode(), pincode);
	}

	@Then("user clicks continue button")
	public void userClicksContinueButton() {
		click(pom.checkout().getContinueButton());
	}

	@Then("validates checkout page and total price")
	public void validatesCheckoutPageAndTotalPrice() throws IOException {
		
		String overview = getText(pom.overviewCheckoutPage().getHeader());
		String checkoutOverview = FileReaderManager.getInstance().getCrInstance().checkoutOverview();
		assertEquals(checkoutOverview, overview);
		
		String totalAmount = getText(pom.overviewCheckoutPage().getTotalAmount());
		String total = FileReaderManager.getInstance().getCrInstance().totalPrice();
		assertEquals(total, totalAmount);
		
		
	}

}
