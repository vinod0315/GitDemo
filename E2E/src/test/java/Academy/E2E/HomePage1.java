package Academy.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObj.ForgottenPassword;
import pageObj.landingPage;
import pageObj.loginPage;
import resources.Base1;



public class HomePage1 extends Base1 {
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(Base1.class.getName());
	@BeforeTest
	public void intilize() throws IOException {
		driver = intilizationDriver();
		

	}

	@Test(dataProvider = "getData")
	public void intilization(String email, String password, String text)  {
		driver.get(prop.getProperty("url"));
		landingPage lp = new landingPage(driver);
		loginPage page=lp.login();
		
		page.getloginId().sendKeys(email);
		page.getPassword().sendKeys(password);
		log.info(text);
		page.getlogin().click();
		ForgottenPassword fp=page.getforgotPassword();
		fp.getmailID().sendKeys("mail@id");
		fp.getsendIns().click();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "emailId@Login";
		data[0][1] = "1234";
		data[0][2] = "Non Restricted user";

		data[1][0] = "login@id";
		data[1][1] = "3456";
		data[1][2] = "Restricted user";

		return data;

	}
	@AfterTest
	public void sleep() {
		driver.close();
	}
	
	}


