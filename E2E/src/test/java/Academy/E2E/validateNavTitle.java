package Academy.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObj.landingPage;
import resources.Base1;



public class validateNavTitle extends Base1 {
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(Base1.class.getName());
	@BeforeTest
	public void intilize() throws IOException {
		driver=intilizationDriver();
		log.info("Driver is initiazed");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	@Test
	public void title() {
		landingPage page=new landingPage(driver);
		
		Assert.assertEquals(page.getTitle().getText(),"FEATURED COURSES");
		log.info("Successfully validated Text Message" );
	}
	@AfterTest
	public void sleep() {
		driver.close();
	}

}
