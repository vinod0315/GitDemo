package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgottenPassword {
	
	public WebDriver driver;
	
	public ForgottenPassword(WebDriver driver) {
		this.driver=driver;
		
	}
	By mailID=By.id("user_email");
	
	By sendIns=By.cssSelector("input[name='commit']");
	
	
	public WebElement getmailID() {
		return driver.findElement(mailID);
		
	}
	public WebElement getsendIns() {
		return driver.findElement(sendIns);
	}
	

}
