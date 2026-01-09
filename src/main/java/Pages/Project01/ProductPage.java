package Pages.Project01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		//PageFactory.initElements(driver.this);
	}
	
	By title = By.className("title");
	
	//@FindBy(className = "title")
	//  WebElement title;
	
	
	
	public String getTitle() {
		
		return driver.findElement(title).getText();
	}
	
}
