package org.junit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	static WebDriver driver;
	static Select select;
	static JavascriptExecutor js;

	public static void browserLaunch(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Adactin\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(url);
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static String getCurrentUrl() {
		String url;
		return url = driver.getCurrentUrl();
	}
	public static String title() {
		String title;
		return title = driver.getTitle();
	}
	public static void to(String url) {
		driver.navigate().to(url);
	}
	public static void forward() {
		driver.navigate().forward();
	}
	public static void backward() {
		driver.navigate().back();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static void quit() {
		driver.quit();
	}
	public static void close() {
		driver.close();
	}
	public static WebElement locators(String loc, String value) {
		WebElement element;
		if(loc.equals("id"))
		{
			return element  = driver.findElement(By.id(value));
		}
		else if(loc.equals("name")) {
			return element = driver.findElement(By.name(value));
		}
		else
		{
		return element= driver.findElement(By.xpath(value));
		}
	}
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	
	public static void click(WebElement element) {
		element.click();
	}
	public static String getText(WebElement element) {
		String text;
		return text = element.getText();
	}
	public static String getAttribute(WebElement element, String text) {
		String attribute;
		return attribute = element.getAttribute(text);
	}
	
	public static void dropDownIndex(WebElement element, int value) {
		 select =new Select(element);
		select.selectByIndex(value);
	}
	public static void dropDownValue(WebElement element,String value) {
		select =new Select(element);
		select.selectByValue(value);
	}
	public static void dropDownVisibleText(WebElement element, String value) {
		select =new Select(element);
		select.selectByVisibleText(value);

	}
	public static void dragDrop(WebElement element, WebElement element1) {
		Actions actions= new Actions(driver);
		actions.dragAndDrop(element, element1).perform();
	}
	public static void movingfElement(WebElement element) {
		Actions actions= new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public static void rightClick(WebElement element) {
		Actions actions= new Actions(driver);
		actions.contextClick(element).perform();
	}
	public static List<WebElement> findElements(String value) {
		List<WebElement> element;
		return element = driver.findElements(By.xpath(value));
	}
	public static void doubleClick(WebElement element) {
		Actions actions= new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public static void screenshot(String location) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d=new File(location);
		FileUtils.copyFile(s, d);	
	}
	public static void scrollIntoView(WebElement element) {
		 js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public static void scrollToBottom() {
		js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrollToUp() {
		js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	public static void jsSendKeys(WebElement element, String text) {
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+text+"')", element);
	}
	public static void jsGetText(WebElement element) {
		js= (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", element);
	}
	public static void jsClick(WebElement element) {
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element);
	}
	
	
	public static String readExcel(String path, String sheetname, int rowindex, int cellindex) throws IOException {
		File f=new File(path);
		FileInputStream stream=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(rowindex);
		Cell cell = row.getCell(cellindex);
		int cellType = cell.getCellType();
		String value;
		if(cellType==1) {
			return value= cell.getStringCellValue();	
		}
		else if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat date=new SimpleDateFormat("dd/MM/yy");
			return value = date.format(dateCellValue);	
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l= (long) numericCellValue;
			return value=String.valueOf(l);
		}
		
	}
	public static void writeExcel(String path, String sheetname, int rowindex, int cellindex, String value) throws IOException {
		File f=new File(path);
		Workbook w=new XSSFWorkbook();
		Sheet createSheet = w.createSheet(sheetname);
		Row createRow = createSheet.createRow(rowindex);
		Cell createCell = createRow.createCell(cellindex);
		createCell.setCellValue(value);
		FileOutputStream stream=new FileOutputStream(f);
		w.write(stream);
	
	}
}
