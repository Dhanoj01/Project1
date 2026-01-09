package tests.Project01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Project01.LoginPage;
import Pages.Project01.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginTest {
    
	WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
	   
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyLogin()
	{
		driver.get("https://www.saucedemo.com/");
		
		LoginPage login = new LoginPage(driver);
		
		login.login("standard_user", "secret_sauce");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProductPage products = new ProductPage(driver);
		
		Assert.assertEquals(products.getTitle(), "Products");
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
