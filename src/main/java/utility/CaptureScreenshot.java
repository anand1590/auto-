package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverFactory.BaseClass;

public class CaptureScreenshot extends BaseClass {
	
	public static  void takeScreenshot() throws IOException
	{
		
		TakesScreenshot tks =(TakesScreenshot)driver;
		File temp = tks.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/image"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(temp, dest);
		
	}

}
