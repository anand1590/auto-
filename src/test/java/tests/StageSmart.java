package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverFactory.BaseClass;

public class StageSmart extends BaseClass {
     
	@Parameters({"uname","pass"})
	@Test(priority=0)
	public void validLoginCheck(String uname, String pass) throws InterruptedException, IOException {
		String actualdashboard = l.doLogin(uname, pass);
		Assert.assertEquals(actualdashboard, "Dashboard");
	}
     
	@Parameters({"user","passw"})
	@Test(priority=1)
	public void invalidLoginCheck(String uname, String pass) throws InterruptedException, IOException {
		String actualErrorMsg= l.doLogin(uname, pass);
		Assert.assertEquals(actualErrorMsg,"Access Denied!");
		
	}

}
