package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	By emailId=By.id("user_email");
	
	By passWord=By.id("user_password");
	
	By logIn=By.xpath("//input[@type='submit']");
	
	By forgotPass=By.cssSelector("a[href*='password/new']");
	
	
	public ForgottenPassword getforgotPassword() {
		driver.findElement(forgotPass).click();
		ForgottenPassword pass=new ForgottenPassword(driver) ;
			return pass;
			
		}
	
	
	public WebElement getloginId() {
		return driver.findElement(emailId);
	}
	public WebElement getPassword() {
		return driver.findElement(passWord);
	}
	public WebElement getlogin() {
		return driver.findElement(logIn);
	}
	

}
