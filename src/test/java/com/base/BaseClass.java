package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	// to get path (upto projectName)
	public static String getPropertyPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	// To get the path
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();

		properties.load(new FileInputStream(getPropertyPath() + "\\Config\\config.properties"));

		return (String) properties.get(key);
	}

	// to wait until find the WebElement
	public void elementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	// WEBDRIVER :I

	public static void getDriver(String browserType) {

		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			break;
		}
	}

	
//	 public void getDriver{
//	 WebDriverManager.chromedriver().setup();
//			 driver = new ChromeDriver();
//	}
	
	public String getUrl(String url) {
		driver.get(url);
		return url;
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

//	public String getCurrentUrl(String url) {
//		String url1 = driver.getCurrentUrl();
//		return url1;
//	}
	public static void getrUrl(String url) {
		driver.get(url);
	}

	public static void close() {
		driver.close();
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public static void maximizewindow() {
		driver.manage().window().maximize();
	}

	public TargetLocator switchTo() {
		TargetLocator switchTo = driver.switchTo();
		return switchTo;
	}

	public String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public Set<String> getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public Navigation navigate() {
		Navigation navigate = driver.navigate();
		return navigate;
	}
	// WEBELEMENT: I

	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void insertValue(WebElement e, String data) {
		e.sendKeys(data);
	}

	public void click(WebElement e) {
		e.click();
	}

	public String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public String getAttribute(WebElement e, String name) {
		String attribute = e.getAttribute(name);
		return attribute;
	}

	public boolean isDisplayed(WebElement e) {
		boolean displayed = e.isDisplayed();
		return displayed;
	}

	public boolean isEnabled(WebElement e) {
		boolean enabled = e.isEnabled();
		return enabled;
	}

	public boolean isSelected(WebElement e) {
		boolean selected = e.isSelected();
		return selected;
	}

	// NAVIGATION : I
	public void forwad() {
		// driver.navigate().forward(); we use navigate method (instance method above)
		navigate().forward();
	}

	public void back() {
		navigate().back();
	}

	public void to(String url) {
		navigate().to(url);
	}

	public void refreshPage() {
		navigate().refresh();
	}
	// ACTIONS : I

	public void moveToElements(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	public void contextClick(WebElement target) {
		Actions a = new Actions(driver);
		a.contextClick(target).perform();
	}

	public void doubleClick(WebElement target) {
		Actions a = new Actions(driver);
		a.doubleClick(target).perform();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public void perform() {
		Actions a = new Actions(driver);
		a.perform(); // CHECK IT
	}

	public void keyUp() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
	}

	public void KeyDown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
	}
	// SELECT : I

	public void selectOptionByIndex(WebElement element, int num) {
		Select s = new Select(element);
		s.selectByIndex(num);
	}

	public void selectOptionByValue(WebElement element, String Value) {
		Select s = new Select(element);
		s.selectByValue(Value);
	}

	public void selectOptionByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void deselectOptionBytext(WebElement element, int num) {

		Select s = new Select(element);
		s.deselectByIndex(num);
	}

	public void deselectOptionByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	public void deselectoptionByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	public void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public List<WebElement> getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}

	public boolean isMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public WebElement getFirstSelectedOptions(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}

	// ALERT :I

	public void acceptalert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void dismissAlert() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public void alterSendkeys(WebElement element, String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(text);
	}

	public void getText() {
		Alert al = driver.switchTo().alert();
		al.getText();
	}

	// FRAMES
	public void switchToFramIdOrName(String IdOrName) {
		driver.switchTo().frame(IdOrName);
	}

	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByrefname(WebElement frameElement) {
		driver.switchTo().frame(frameElement);

	}

	public static void implicitWait(long seconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public static String getData(String name, int rowNum, int cellNum) throws IOException {

		String value = null;

		File f = new File("C:\\Users\\HP\\eclipse-workspace1\\POMFramework\\Excel\\AdactinData.xlsx");
		FileInputStream file = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(file);
		Sheet s = w.getSheet(name);
		Row r = s.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		CellType type = c.getCellType();

		switch (type) {

		case STRING:
			value = c.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(c)) {
				java.util.Date date = c.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
				value = dateFormat.format(date);
			} else {
				double numericCellValue = c.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);

			}

		default:
			break;
		}
		return value;

	}

	public void updateData(String name, int rowNum, int column, String Value) throws IOException {
		File f = new File("C:\\Users\\HP\\eclipse-workspace1\\POMFramework\\Excel\\AdactinData.xlsx");
		FileInputStream file = new FileInputStream(f);
		Workbook w= new XSSFWorkbook(file); // w.close(); to close this warning sign
		Sheet s = w.getSheet(name);
		Row r = s.getRow(rowNum);
		Cell c = r.createCell(column);
		c.setCellValue(Value);
		FileOutputStream outputStream = new FileOutputStream(f);
		w.write(outputStream);

	}

}
