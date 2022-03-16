package AddressTestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CRUD.Address;
import CRUD.AddressPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddressTest {
	
	WebDriver driver ;
	AddressPage addressPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    driver.get("http://a.testaddressbook.com/sign_in");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("session_email")).sendKeys("naveenanimation20@gmail.com");
	    driver.findElement(By.id("session_password")).sendKeys("Test@12345");
//	    Thread.sleep(3000);
	    driver.findElement(By.name("commit")).click();	
//	    Thread.sleep(3000);
	    
	    addressPage = new AddressPage(driver);
	    	    
	}
	
	@Test
	public void createAddressTest() {
		Address address = new Address("Jayesh", "QA", "new Address", "pune", "423301");
		String successMsg = addressPage.addAddress(address);	
		Assert.assertEquals(successMsg, "Address was successfully created.");	
	}
	
	@Test
	public void updateAddressTest() {
		Address address = new Address("JayeshUpdate", "QAUpdate", "new Address update", "pune update", "423302");
		addressPage.addAddress(address);
		address.setLastname("Gangurde");
		address.setCity("Nashik");
		String successMsg = addressPage.updateAddress(address, address.getFistname());
		Assert.assertEquals(successMsg, "Address was successfully updated.");
	}
	
	@Test
	public void deleteAddressTest() {
		Address address = new Address("JayeshDelete", "QADelete", "new Address Delete", "pune Delete", "423303");
		addressPage.addAddress(address);
		String successMsg = addressPage.deleteAddress("JayeshDelete");
		Assert.assertEquals(successMsg, "Address was successfully destroyed.");
	}
	
	@Test
	public void getAddressTest() {
		Address address = new Address("Jayesh get", "QA get", "new Address get", "pune get", "423304");
		addressPage.addAddress(address);
		String actFirstName = addressPage.getAddress("Jayesh get");
		Assert.assertEquals(actFirstName, address.getFistname());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
