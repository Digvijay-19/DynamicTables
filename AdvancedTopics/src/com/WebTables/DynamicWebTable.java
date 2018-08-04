package com.WebTables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Selenium Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("Iphone");
		driver.findElement(By.name("password")).sendKeys("Bank$123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		WebElement frameElement = driver.findElement(By.name("mainpanel"));
		driver.switchTo().frame(frameElement);
		WebElement contactElement = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		Actions action = new Actions(driver);
        action.moveToElement(contactElement).click().build().perform();
        //WebElement element1 = driver.findElement(By.xpath("//*[@id='vContactsForm']/child::table/child::tbody/child::tr[4]/child::td/input[@name='contact_id']"));
        WebElement element = driver.findElement(By.xpath("//td[@class='datatitle']/strong[contains(text(),'Name')]"));
        System.out.print(element.getText());
        List<WebElement>  details = driver.findElements(By.xpath("//form[@id='vContactsForm']/table/tbody/tr//following-sibling::tr/child::td[2]//a[contains(text(),'Balukbc Kammari')]"));
        for(int i=0;i<details.size();i++)
        {
            System.out.print("\n"+details.get(i).getText());

        }

        driver.close();
		

	}

}
