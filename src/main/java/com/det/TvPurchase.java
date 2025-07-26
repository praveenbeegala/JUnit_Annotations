package com.det;

import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TvPurchase {
	  static long start;
	  static WebDriver driver ;
	  static String text;
	  static String text2;
	   @BeforeClass
     public static void browserla() {
		    System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		    driver = new ChromeDriver(); 
		    driver.get("https://www.flipkart.com/");
		    driver.manage().window().maximize();
			System.out.println("Browser Launch");
		 }
	   @AfterClass
	   public static void browserquit() {
		     driver.quit();
			 System.out.println("Broser Quit");
		 }
	  @Before
	 public void timestart() {
		 start = System.currentTimeMillis();
	 }
	 @After
	 public void endtime() {
		 long end = System.currentTimeMillis();
		 System.out.println("After TotalTime"+(end - start));
	 }
	 @Test
	 public void method1() throws InterruptedException {
		 WebElement searchbox = driver.findElement(By.name("q"));
		    searchbox.sendKeys("Nothing Phone");
		    searchbox.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//div[text()='Nothing Phone (3a) (White, 128 GB)']")).click();
		    Thread.sleep(3000);
		    System.out.println("Product Clicked");
	 }
	 @Test
	 public void method2() throws InterruptedException {
		 WebElement ProductName = driver.findElement(By.xpath("//div[text()='Nothing Phone (3a) (White, 128 GB)']"));
		 text= ProductName.getText();
		 System.out.println(text);
   }
	 @Test
	 public void method3() {
		 String pwin = driver.getWindowHandle();
		 Set<String> allwin = driver.getWindowHandles();
		 for(String x :allwin) {
			 if(!pwin.equals(x)){
				 driver.switchTo().window(x);
			 }
		 }
		 WebElement ProductTitle =  driver.findElement(By.xpath("//span[@class='VU-ZEz']"));
		 text2 = ProductTitle.getText();
		 System.out.println(text2);
	 }
	 @Test
	 public void method4() {
		 if (text.equals(text2)){
			 System.out.println("Text Mtached");		
	        }else {
	         System.out.println("Text MissMtach");
	        }
	 }
	 @Ignore
	 @Test
	 public void method5() {
		 System.out.println("Task Completed Day 3");
	 }

}
