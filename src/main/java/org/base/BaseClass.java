package org.base;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	  public static WebDriver driver;
	 
	          //CHROME LAUNCH-----------1
	 
	 public static WebDriver chromeLaunch() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 return driver;
	 
	 }
	           //URL LAUNCH-----------2
	 public static void urlLaunch(String url) {
	 driver.get(url);
	 }
	 
	           //IMPWAIT-----------3
	 public static void impWait() {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	 }
	 
	           //SENDKEYS---------4
	 public static void sendkeys(WebElement e,String data) {
		 e.sendKeys(data);
	 }
	          //GETCURRENTURL-------------5
	 public static String getCurrentUrl() {
		 String url = driver.getCurrentUrl();
		 return url;
	 }
	 
	          //CLICK--------------6
	 public static void click(WebElement e) {
		e.click();

	} 
	        //QUIT----------------7
	   public static void quit() {
	 // driver.quit();
	  }
	       //CLOSE------------8
	// public static void close() {
//		driver.close();
	//}

	        //GET ATTRIBUTE-------------9
	 
	 public static String getAttribute(WebElement e) {
		String s = e.getAttribute("value");
		return s;

	}
	 //MOVE TO ELEMENT----------10
	 public static  void moveToElement(WebElement e) {
		 Actions s=new Actions(driver);
	     s.moveToElement(e).perform();
	}
	 
	         //DRAG AND DROP-----------11
	 public static void dragAndDrop(WebElement from,WebElement to) {
		Actions s=new Actions(driver);
	    s.dragAndDrop(from, to).perform();
	}
	        //ACTION CLICK----------12
	 public static void actionClick(WebElement target) {
		Actions s=new Actions(driver);
		s.click(target).perform();

	}
	 //CONTEXT CLICK------------13
	 public static void contextClick() {
		 Actions s=new Actions(driver);
	     s.contextClick().perform();
	}
	 //DOUBLE CLICK--------------14
	 public static void doubleClick(WebElement target) {
	       Actions s=new Actions(driver);
	       s.doubleClick(target).perform();
	}
	 //CLIK AND HOLD---------15
	 public static void clickAndHold(WebElement target) {
		 Actions s=new Actions(driver);
	     s.clickAndHold(target).perform();
	}
	         //SIMPLE ALERT-----------16
	 public static void simpleAlert() {
		Alert l=driver.switchTo().alert();
	    l.accept();
	}
	         //SELECT DROP DOWN      SELECT BY INDEX----------17
	 public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
	s.selectByIndex(index);
	}
	 //SELECT BY VALUE-------------18
	 public static void selectByValue(WebElement e,String value) {
			Select s=new Select(e);
		s.selectByValue(value);
	 }
	 //SELECT BY VISIBLE TEXT------------19
	 public static void selectByVisibleText(WebElement e,String text) {
			Select s=new Select(e);
		s.selectByVisibleText(text);
	 }
	 //IS MULTIPLE-------------20
	 public static void isMultiple(boolean b) {
			isMultiple(b);
	 }
	 //GET ALL SELECTED OPTION--------21
	 public static void getFirstSelectedOptions(WebElement e) {
			Select s=new Select(e);
		s.getAllSelectedOptions();
	 }
	 //DESELECT BY INDEX-----------22
	 public static void deSelectByIndex(WebElement e,int index) {
			Select s=new Select(e);
		s.deselectByIndex(index);
	 }
	 //DESELECT BY VALUE---------23
	 public static void deSelectByValue(WebElement e,String value) {
			Select s=new Select(e);
		s.deselectByValue(value);
	 }
	 //DESELECT BY VISIBLE TEXT-----24
	 public static void deSelectByVisibleText(WebElement e,String text) {
			Select s=new Select(e);
		s.deselectByVisibleText(text);
	 }
	         //FRAMES     SWITCH TO  INDEX----25
	 public static void switchIntoFrame(int index) {
		driver.switchTo().frame(index);
	}
	 //SWITCH TO ID-----------26
	 public static void switchIntoFrame(String id) {
			driver.switchTo().frame(id);
		}
	 //SWITCH TO NAME----------27
	 public static void switchtoFrame(String name) {
			driver.switchTo().frame(name);
		}
	 //SWITCH TO ELEMENT-----------28
	 public static void switchIntoFrame(WebElement e) {
			driver.switchTo().frame(e);
		}
	 
	         //JAVA SCRIPT EXECUTOR -SENDKEYS-------29
	 
	 public static void jSInsert(WebElement e,String data) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].setAttribute('value','("+data+")')", e);
	                                                          //anu        //txtuser
	 }	
	 
	          //INSERT-----------30
	 public static void jsInsert(WebElement e,String data) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].setAttribute('value','("+data+")')", e);
	                                                          //greens
	}
	         //GETATTRIBUTE------------31
	 public static String jsGetAttribute(WebElement e) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 Object obj = js.executeScript("return arguments[0].getAttribute('value')", e);
	     String s2=(String)obj;
	     return s2;
	}
	         //JS CLICK---------------32
	 public  void jsClick(WebElement e) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()", e);
	}
	        //SCROLL DOWN-----------------33
	 public static void jsScrollDown(WebElement e) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].srollIntoView(true)", e);

	}
	        //SCROLL UP--------------34
	 public static void jsScrollUp(WebElement e) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(false)", e);

	}
	 
	        //SCREENSHOT-------------35
	 public static void takeScreenshot(String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File from=ts.getScreenshotAs(OutputType.FILE);
	    File to=new File("c:user\\hp\\eclipse-workspace\\MavenProjectJune\\src\\main\\resources\\Screenshots\\"+ name +".png");
	    FileUtils.copyFile(from , to);
	 }
	 //WINDOWS HANDLING   GETWINDOWHANDLE-----------36
	 
	 //GET WINDOWHANDLES-----------37
	 public static Set<String> WindowHandles(WebElement e) {
			Set<String> allid =driver.getWindowHandles();
			return allid;
		 }
	 
	 //NAVIGATION COMMAND BACK-----38
	 public static void navigateBack() {
			driver.navigate().back();
			
		 }
	 //NAVIGATION -FORWARD------------39
	 public static void navigateforward() {
			driver.navigate().forward();
			
		 }
	 //NAVIGATION-REFRESH-----------40
	 public static void navigateRefresh() {
			driver.navigate().refresh();
			
		 }
	 //IS DISPLAYED-----------41
	 public static boolean isDisplayed(WebElement e) {
			boolean dp = e.isDisplayed();
			return dp;
		 }
	 //IS ENABLED--------------42
	 public static boolean isEnabled(WebElement e) {
			boolean eb = e.isEnabled();
			return eb;
		 }
	 //IS SELECTED----------------43
	 public static boolean isSelected(WebElement e) {
			boolean sc = e.isSelected();
			return sc;
		 }
	 
	 
	 }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

