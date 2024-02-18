package driverFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginStageSmart;

public class BaseClass {
	public static WebDriver driver;
	public static LoginStageSmart l= new LoginStageSmart();
	
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) throws IOException
	{
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		
		FileReader fr = new FileReader(f);
		
		Properties prop= new Properties();
		
		prop.load(fr);
		ChromeOptions c = new ChromeOptions();
		c.addArguments("--incognito");
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(options);
	
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			EdgeOptions options = new EdgeOptions();
	        options.setCapability("headless", true);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		}

		driver.get(prop.getProperty("testUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
//	@AfterMethod
//	public void tear()
//	{
//		driver.quit();
//	}
	

}
