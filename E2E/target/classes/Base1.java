package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class Base1 {

	public WebDriver driver;

	public Properties prop;

	public WebDriver intilizationDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\vinod kumar\\Eclipse-Files\\E2E\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		
	//	String browserName=System.getProperty("browser");

		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
	

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "c:\\work\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "c:\\work\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
		
		return driver;

	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		FileUtils.copyFile(source,new File(destinationFile));
		
		return destinationFile;				
	}

}
