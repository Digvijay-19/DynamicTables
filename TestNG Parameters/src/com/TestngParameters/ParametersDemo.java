package com.TestngParameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

	
	WebDriver driver;
	
	@Test
	@Parameters({"browser","url","username","password"})
	public void DemoOne(String browser,String url,String username,String password) throws InterruptedException{
		
		if(browser.equals("chrome"))
		{
		 System.setProperty("webdriver.chrome.driver", "D://Selenium Drivers//chromedriver.exe");
		 driver = new ChromeDriver();
		}
		
		if(browser.equals("firefox")) {
		
			 System.setProperty("webdriver.gecko.driver", "D://Selenium Drivers//geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		System.out.println(driver.getTitle());
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit' and  @value ='Login']")).click();
		System.out.println(driver.getTitle());
		}
	

}
