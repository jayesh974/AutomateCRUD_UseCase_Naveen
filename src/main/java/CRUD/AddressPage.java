package CRUD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {

	WebDriver driver;

	private By fistname = By.id("address_first_name");
	private By lastname = By.id("address_last_name");
	private By address1 = By.id("address_street_address");
	private By city = By.id("address_city");
	private By zipcode = By.id("address_zip_code");
	private By createAddress = By.name("commit");
	private By successMsg = By.cssSelector(".alert.alert-notice");
	private By firstNameValue = By.xpath("//span[@data-test='first_name']");
	private By addressesLink = By.xpath("//a[@data-test='addresses']");
	private By newAddressLink = By.xpath("//a[@data-test='create']");
	

	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddressesLink() {

		driver.findElement(addressesLink).click();
	}

	private String fillAddressForm(Address address) {
		
		driver.findElement(fistname).clear();
		driver.findElement(fistname).sendKeys(address.getFistname());
		
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys(address.getLastname());
		
		driver.findElement(address1).clear();
		driver.findElement(address1).sendKeys(address.getAddrees1());
		
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(address.getCity());
		
		driver.findElement(zipcode).clear();
		driver.findElement(zipcode).sendKeys(address.getZipcode());
		
		driver.findElement(createAddress).click();
		return driver.findElement(successMsg).getText();
	}

	public String addAddress(Address address) {
		clickAddressesLink();
		driver.findElement(newAddressLink).click();
		return fillAddressForm(address);
	}

	public String updateAddress(Address address, String FName) {
		clickAddressesLink();
		driver.findElement(By.xpath(" //td[text()='" + FName + "']//following-sibling::td//a[text()='Edit']")).click();
		return fillAddressForm(address);

	}

	public String deleteAddress(String FName) {
		clickAddressesLink();
		driver.findElement(By.xpath(" //td[text()='" + FName + "']//following-sibling::td//a[text()='Destroy']"))
				.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		return driver.findElement(successMsg).getText();
	}

	public String getAddress(String FName) {
		clickAddressesLink();
		driver.findElement(By.xpath(" //td[text()='" + FName + "']//following-sibling::td//a[text()='Show']")).click();
		return driver.findElement(firstNameValue).getText();

	}

}
