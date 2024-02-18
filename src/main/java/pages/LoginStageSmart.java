package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.BaseClass;
import utility.CaptureScreenshot;

public class LoginStageSmart extends BaseClass {
	
	By username = By .id("user_name");
	By password = By.id("password");
	By login = By.xpath("//button[@type='submit']");
	By dashboard = By.xpath("(//span[text()='Dashboard'])[1]");
	By notify= By.xpath("//div[@class='ant-notification-notice-message']");
	
	//Actions 
	public String doLogin(String user, String passw) throws InterruptedException, IOException
	{
		String text="";
		WebElement uname  = driver.findElement(username);
		uname.sendKeys(user);
		WebElement pass = driver.findElement(password);
		pass.sendKeys(passw);
		WebElement loginbutton = driver.findElement(login);
		loginbutton.click();
		Thread.sleep(2000);
		String homepageUrl = driver.getCurrentUrl();
		System.out.println(homepageUrl);
		if(homepageUrl.equals("https://stage.smartcondo.xyz/wms-dashboard"))
		{
			
			Thread.sleep(3000);
			WebElement dashBoard = driver.findElement(dashboard);
			 text = dashBoard.getText();
			 CaptureScreenshot.takeScreenshot();
			
		}
		else
		{
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement notification = wait.until(ExpectedConditions.presenceOfElementLocated(notify));
			text = notification.getText();
			
		}
		return text;
		
		
	}
	
	
}
