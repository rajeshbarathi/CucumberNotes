package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	
	Properties prop;

	public ConfigurationReader() throws IOException {
		
		File file = new File("src\\test\\java\\helper\\data.property");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
	}

	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}
	
	public String getURL() {
		String url = prop.getProperty("url");
		return url;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getLabsURL() {
		String labsurl = prop.getProperty("labsURL");
		return labsurl;
	}
	
	public String productHeader() {
		String productHeader = prop.getProperty("productHeader");
		return productHeader;

	}
	public String cartHeader() {
		String cartPageHeader = prop.getProperty("cartHeader");
		return cartPageHeader;

	}
	public String checkOutHeader() {
		String checkoutHeader = prop.getProperty("checkOutHeader");
		return checkoutHeader;

	}
	public String checkoutOverview() {
		String overview = prop.getProperty("checkoutOverview");
		return overview;

	}
	public String totalPrice () {
		String total = prop.getProperty("total");
		return total;

	}
	
}
