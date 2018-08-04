package com.Assertions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoHardAssertion {

	
	WebDriver driver;
	SoftAssert ssert;
	WebElement iframe;
	WebElement account;
	Actions action;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D:/Selenium Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(-40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("Iphone");
		driver.findElement(By.name("password")).sendKeys("Bank$123");
		driver.findElement(By.xpath("//input[@type='submit' and  @value ='Login']")).click();
		
	}
	
	@Test(priority=1)
	public void LoginTest(){
		String title = driver.getTitle();
		Assert.assertEquals(title, "CRMPRO");
		//Assert.assertAll();
	}
	
	@Test(priority=2)
	public void verifyAccountDetails(){
		 iframe = driver.findElement(By.name("mainpanel"));
		 driver.switchTo().frame(iframe);
		 account =  driver.findElement(By.xpath("//a[contains(text(),'Upgrade your account')]"));
		 action.moveToElement(account).click().build().perform();
		 }
	
	@AfterMethod
	public void breakDown(){
		driver.quit();
	}
}
