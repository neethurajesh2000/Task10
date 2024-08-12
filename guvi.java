package com.seleniumfundamental.task10;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;


public class  guvi{
	
	 protected static String url="https://www.guvi.in/";
	  WebDriver driver;
	  
	  @BeforeSuite
	  public void startChromeBrowser() {
	      WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();		  
	  }
	  
	  @Test
	  public void registertest() throws InterruptedException {
		  driver.get(url);
		  driver.findElement(By.xpath("//*[.='Sign up']")).click();	
		 
		  Thread.sleep(2000);
		  
//		  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Sign up']")));  
		
	  JavascriptExecutor js= (JavascriptExecutor) driver;//type webDriver to javascriptExecutor			
	  WebElement elementlocator=driver.findElement(By.id("signup-btn"));
	  js.executeScript("arguments[0].scrollIntoView(true)",elementlocator);
	  Thread.sleep(1000);
		  
		  
		  WebElement fullname=driver.findElement(By.id("name"));
		  fullname.sendKeys("Neethu Mathew");
		  
		  WebElement email=driver.findElement(By.id("email"));
		  email.sendKeys("maya12@gmail.com");
		  
		  WebElement password=driver.findElement(By.id("password"));
		  password.sendKeys("maya123");
		  
		  WebElement mobileNumber=driver.findElement(By.id("mobileNumber"));
		  mobileNumber.sendKeys("9578235678");
		  
		  WebElement SignUpbutton=driver.findElement(By.id("signup-btn"));
		  SignUpbutton.click();
		 
		  Thread.sleep(2000);
		  
		  WebElement selectelement=driver.findElement(By.id("profileDrpDwn"));
		  //create an object of Select class
		  Select select=new Select(selectelement);
		  select.selectByIndex(1);
//		  select.selectByVisibleText("looking for a career");
		  Thread.sleep(1000);
		  
		  WebElement selectelement1=driver.findElement(By.id("degreeDrpDwn"));
		  //create an object of Select class
		  Select select1=new Select(selectelement1);
		  select1.selectByIndex(1);
//		  select1.selectByVisibleText("M.E. / M.Tech. Computer Science");
		  Thread.sleep(1000);
		  
		  WebElement passyear=driver.findElement(By.id("year"));
		  passyear.sendKeys("2012");		  
		  WebElement submitbtn=driver.findElement(By.id("details-btn"));
		  submitbtn.click();
		  Thread.sleep(2000);
		  driver.navigate().back();
		  
//		  Login after signup
		  WebElement loginbtn=driver.findElement(By.id("login-btn"));
		  loginbtn.click();
		  WebElement loginemail=driver.findElement(By.xpath("//input[@id='email']"));
		  loginemail.sendKeys("maya12@gmail.com");
		  WebElement loginpassword=driver.findElement(By.xpath("//input[@id='password']"));
		  loginpassword.sendKeys("maya123");
		  WebElement loginbtn1=driver.findElement(By.xpath("//a[@id='login-btn']"));
		  loginbtn1.click();
		  Thread.sleep(2000);
		  
	  }
	  	  
	  @AfterSuite
	  public void closeChromeBrowser() {
		  driver.quit();
	  }

}