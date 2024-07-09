package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;

public class Test1 extends BaseTest
{
	@Test(dataProviderClass = ReadXLSData.class, dataProvider = "testdata")
	void loginTest(String uname, String pwd) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(loc.getProperty("signin_link"))).click();
		driver.findElement(By.xpath(loc.getProperty("email_fld"))).sendKeys(uname);
		driver.findElement(By.xpath(loc.getProperty("next_btn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("pwd_fld"))).sendKeys(pwd);
		driver.findElement(By.xpath(loc.getProperty("login_btn"))).click();
		Thread.sleep(2000);

		Assert.assertEquals(driver.getTitle(), "Explore All Products | Zoho");

	}

}
