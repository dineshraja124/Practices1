package org.cursor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Giggso {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		option.addArguments("--disable-notifications");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
        option.setExperimentalOption("prefs", prefs);
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://kc.giggso.com/auth/realms/giggso/protocol/openid-connect/auth?client_id=angular-cors&redirect_uri=https%3A%2F%2Fapp.giggso.com%2Flogin&state=b8dc5830-cabe-43f7-976d-0c07d762e532&response_mode=fragment&response_type=code&scope=openid&nonce=3bbdf4dc-0c03-483d-bfb3-3e2e1b7061e8");
 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("giggso.dineshr@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dINesh248124");
		driver.findElement(By.xpath("//input[@id='kc-login']")).click();
		driver.findElement(By.xpath("//li[@class='apps-menu-icon appshelp']")).click();
		
		boolean condition =true;
		while (condition) {
			try {
				WebElement workflowBtn = driver.findElement(By.xpath("//div[@id='workflow']//following-sibling::div//button"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true)", workflowBtn);
				Thread.sleep(10000);
				WebElement azureBtn = driver.findElement(By.xpath("//div[@id='azure']//following-sibling::div//button"));
				js.executeScript("arguments[0].scrollIntoView(false)", azureBtn);
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("---Completed -----");
			} 
		}
	}

}
