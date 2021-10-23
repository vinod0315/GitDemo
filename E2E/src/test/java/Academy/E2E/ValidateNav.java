package Academy.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObj.landingPage;
import resources.Base1;



public class ValidateNav extends Base1{
	public WebDriver driver;
	
	@BeforeTest
	public void intilize() throws IOException {
		driver=intilizationDriver();
		driver.get(prop.getProperty("url"));
		
	}
	@Test
	public void visiableNavBar() {
		landingPage page=new landingPage(driver);
		
		Assert.assertTrue(page.getNavigation().isDisplayed());
		
	}
	@AfterTest
	public void sleep() {
		driver.close();
	}

}
