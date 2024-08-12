package com.seleniumfundamental.task10;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calender {

	protected static String url="https://jqueryui.com/datepicker/";
	 WebDriver driver;
	@BeforeSuite
	 public void startChromeBrowser() {
		 WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 }
	 @BeforeClass
	 public void openUrl() {
		  driver.get(url);
	
	 }
	  @Test
	  public void handlecalender() throws InterruptedException {
		  //navigate inside the frame
		  driver.switchTo().frame(0);
		  driver.findElement(By.id("datepicker")).click();
		  
		 //avoid synchroinzation  
		  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker")));
		  
		  driver.findElement(By.xpath("//a[@title='Next']")).click();		  

		  
		  WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(40));
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Next']")));
		  
		  driver.findElement(By.xpath("//table/tbody/tr/td/a[.='22']")).click();
		  
		  //get the value and print in console same date selection
		  WebElement datelement=driver.findElement(By.id("datepicker"));
		  String date= datelement.getAttribute("value");
		  System.out.println("The selected date and month is  "+date);
		  
	  }
	  
	  @AfterSuite		
	  public void closeChromeBrowser() {
			  driver.quit();
	  }
}
  

