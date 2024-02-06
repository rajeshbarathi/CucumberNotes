package helper;

import org.openqa.selenium.WebDriver;

import pomClass.CartPage;
import pomClass.CheckoutInfoPage;
import pomClass.LoginPage;
import pomClass.OverviewCheckoutPage;
import pomClass.ProductsPage;

public class PageObjectManager {
	
	private LoginPage lp;
	private ProductsPage pp;
	private CartPage cp;
	private CheckoutInfoPage cop;
	private OverviewCheckoutPage ocp;

	 WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		
		this.driver = driver;
	}

	public LoginPage getlp() {
		lp = new LoginPage(driver);
		return lp;
	}
	
	public ProductsPage getProductsPage() {
		pp = new ProductsPage(driver);
		return pp;
	}
	
	public CartPage cartPage() {
		cp = new CartPage(driver);
		return cp;
	}
	
	public CheckoutInfoPage checkout() {
		cop = new CheckoutInfoPage(driver);
		return cop;
	}
	
	public OverviewCheckoutPage overviewCheckoutPage() {
		ocp = new OverviewCheckoutPage(driver);
		return ocp;
	}
}
