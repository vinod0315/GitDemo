package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	public landingPage(WebDriver driver) {
		this.driver = driver;

	}

	By signIn = By.cssSelector("a[href*='sign_in']");
	
	By title=By.xpath("//div[@class='text-center']/h2");
	
	By navigation=By.xpath("//ul[@class='nav navbar-nav navbar-right']");

	public loginPage login() {
		 driver.findElement(signIn).click();
		 
		 loginPage p=new loginPage(driver);
		 return p;
		 
		 
		
		 
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigation() {
		return driver.findElement(navigation);
	}
}
