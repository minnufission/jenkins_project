package com;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest {
  @Test(priority=1)
  public void LoginTestWithValidCredentials() {
	  System.setProperty("Webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.id("username")).sendKeys("saurabh@arcscorp.com");
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("paclife1");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		//WebElement element= driver.findElement(By.xpath("//*[contains(text(),'Log In to Salesforce'))]"));
		WebElement element= driver.findElement(By.xpath("//*[contains(text(),'Log In to Salesforce')]"));
		//System.out.println("element found");
		Assert.assertTrue(element.isDisplayed(), "Login successfully");
		 }
  
 @Test(priority=2)
  public void LoginTestWithInvalidCredentials() {
	  System.setProperty("Webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.id("username")).sendKeys("saurabh@arcscorp.com");
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		assertTrue(driver.findElement(By.xpath("//div[@id='error']")).isDisplayed(), "Wrong username or password!");
		
  }
}
