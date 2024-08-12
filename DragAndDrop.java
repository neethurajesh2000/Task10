package com.seleniumfundamental.task10;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	
	 protected static String url="https://jqueryui.com/droppable/";
	  WebDriver driver;
	  
	  @BeforeSuite
	  public void startChromeBrowser() {
	      WebDriverManager.chromedriver().setup();//setup required initially.
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();	
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	  
	  @Test
	  public void draganddroptest() throws InterruptedException {
		  driver.get(url);
		  //switch to frame
		  driver.switchTo().frame(0);//index approach
		  
		  //locate an element of drag and drop box
		  WebElement source=driver.findElement(By.id("draggable"));
		  WebElement destination=driver.findElement(By.id("droppable"));

		  //before dropping
		  String pretext=destination.getText();//drop here
		  String precolor=destination.getCssValue("background-color");
		  System.out.println(pretext);
		  System.out.println(precolor);
		  
		  //perform an action-
		  Actions actions=new Actions(driver);
		  actions.dragAndDrop(source, destination).perform();
		  
		//avoid synchroinzation  
		  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		  		  
		  //after dropping
		  String aftertext=destination.getText();//drop here
		  String aftercolor=destination.getCssValue("background-color");
		  System.out.println(aftertext);
		  System.out.println(aftercolor);
		  		  
//		  //validate 
		  if(aftertext.equals("Dropped!") && aftercolor.equals("rgba(255, 250, 144, 1)"))
		  {
			  System.out.println("Drag and Drop sucessfully done.");
		  }else {
			  System.out.println("Drag and Drop operation are not done properly");
		  }
	  }
	  
	  @AfterSuite
	  public void closeChromeBrowser() {
		  driver.quit();
	  }

}