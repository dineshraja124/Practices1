package org.cursor;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CursorMove {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();

		
		boolean condition =true;
		 while(condition) {
		   try {
			WebElement element = driver.findElement(By.xpath("//li[@class='nav_first']/a[text()='About Us']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			
			WebElement electonicsbtn = driver.findElement(By.xpath("(//div[@class='a-cardui-body']//div[@class='a-section center-image aok-block image-window'])[2]"));
			Thread.sleep(3000);
			js.executeScript("arguments[0].scrollIntoView(false)", electonicsbtn);
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			e.printStackTrace();
	    	}finally {
			System.out.println("Completed --------");
		  }
		}
		
	}
}
