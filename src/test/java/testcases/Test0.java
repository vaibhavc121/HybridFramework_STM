package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class Test0 extends BaseTest
{
	@Test(dataProvider = "testdata")
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

	@DataProvider(name = "testdata")
	public Object[][] testData()
	{
		Object data[][] =
		{
				{ "abc@gmail.com", "testi23" },
				// { "xyz@gmail.com", "teste12" },
				// { "john@gmail.com", "test@123" },
				{ "pavan01123@gmai1.com", "tegt@123" },
				{ "v7769967226@gmail.com", "vaibhavc@123" }, };
		return data;
	}
}
