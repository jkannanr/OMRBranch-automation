package baseClass;

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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassCucumber {

	public static WebDriver driver;

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\config\\config.properties"));
		String value = (String) properties.get(key);
		return value;

	}

	public byte[] screenshot() {

		TakesScreenshot screenshot=(TakesScreenshot)driver;
		byte[] b=screenshot.getScreenshotAs(OutputType.BYTES);
		return b;
		
	}
	
	// 99% value --> get inserted value from textbox
	public static String elementGetAttributeValue(WebElement element) {
		elementVisibility(element);
		String attribute = element.getAttribute("value");
		return attribute;
	}

	// 1% value --> get inserted value from textbox
	public static String elementGetAttributeValue(WebElement element, String attributeName) {
		elementVisibility(element);
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

//	65.Get Property file path
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}

//	64. Explicit wait2

	public static void elementVisibility(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

//	63. ExplicitWait

	public WebElement explicitWaitvisibilityOfElementLocated(String xpression) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpression)));
	}

//	62. implicitWait

	public void implicitWait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	}

	// 60.To create aCELL and INSERT VALUE

	protected static void updateCellData(String sheetname, int rownum, int cellnum, String data) throws IOException {

		File file = new File("C:\\Users\\jkann\\eclipse-workspace\\MavenPom\\Excelsheet\\TestDataAdactin.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	// 59.To update celldata

	public void updateCellData1(String sheetname, int rownum, int cellnum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\jkann\\eclipse-workspace\\MavenPom\\Excelsheet\\TestDataAdactin.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	// 58.To read data from Excel

	public String readDataFromCell(String sheetname, int rownum, int cellnum) throws IOException {
		String res = "";
		File file = new File("C:\\Users\\jkann\\eclipse-workspace\\MavenPom\\Excelsheet\\TestDataAdactin.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:

			res = cell.getStringCellValue();
			break;

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("DD/mm/yyy");
				res = dateFormat.format(dateCellValue);
			}

			else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);

				if (check == numericCellValue) {

					res = String.valueOf(check);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}

			break;

		default:
			break;
		}

		return res;

	}

//1.getURL
	public static void getUrl(String url) {
		driver.get(url);
	}

//2.maximizeWindow
	public static void maximizeWindow() {

		driver.manage().window().maximize();
	}

//3.Insert value in text box
	public void elementSendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void elementKeysEnter(WebElement element, String value, Keys enter) {
		element.sendKeys(value);
	}

//4.click button
	public void elementClick(WebElement element) {

		elementVisibility(element);
		element.click();
	}

//5.Launch ChromeBrowser
	public static void getDriver(String browserName) {

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
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

//6.Click OK in alert box
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

//7. Click CANCEL in alert boc
	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

//8.get text from webpage
	public String elementGetText(WebElement element) {
		elementVisibility(element);
		String text = element.getText();
		return text;
	}

//9.Insert Value using js
//	public void elementSendKeysJs(WebElement element, String data) {
//		elementVisibility( element);
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].setAttribute('value', '" + data + "')", element);
//	}

//10.get application title
	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;

	}

//11.Find Locator by ID
	public WebElement findElementById(String attributeValue) {

		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

//12.Find Locator by NAME
	public WebElement findElementByName(String attributeValue) {

		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	// 13.Find Locator by CLASSNAME
	public WebElement findElementByClassName(String attributeValue) {

		WebElement element = driver.findElement(By.className(attributeValue));
		return element;

	}

	// 14.Find Locator by XPATH
	public WebElement findElementByXpath(String expression) {

		WebElement element = driver.findElement(By.xpath(expression));
		return element;
	}

//15.CLose current WIndow
	public void closeWindow() {
		driver.close();
	}

//16.CLose All WIndows
	public static void quitWindow() {
		driver.quit();
	}

//17.Select dropdown by TEXT
	public String selectOptionByText(WebElement element, String text) {

		elementVisibility(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
		return text;
	}

	// 18.Select dropdown by INDEX
	public int selectOptionByIndex(WebElement element, int index) {

		elementVisibility(element);
		Select select = new Select(element);
		select.selectByIndex(index);
		return index;
	}

	// 19.Select dropdown by ATTRIBUTE VALUE
	public void selectOptionByAttribute(WebElement element, String value) {

		elementVisibility(element);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

//	20.Select dropdown by js
	public void elementClickByJs(WebElement element, String data) {
		elementVisibility(element);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

//	21.Get the inserted value from the textbox

	public String elementGetAttribute(WebElement element) {
		elementVisibility(element);
		String attribute = element.getAttribute("value");
		return attribute;
	}

//	public void presenceOfElementLocated(WebElement element) {
//
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.presenceOfElementLocated(element));
//		}
//		

//	22.Get the inserted value from the textbox by string

	public String elemetGetAttribute1(WebElement element, String attributeName) {
		elementVisibility(element);
		String attribute = element.getAttribute(attributeName);
		return attribute;

	}

//	23.Get Child Window
	public void getCurrentWindow() {
		String currentWindow = driver.getWindowHandle();
		driver.switchTo().window(currentWindow);

	}

//	24.Get Parent Window name
	public String getParentWindow() {
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		return parent;

	}

// 25. return the number of windows opened by Webdriver and will return Set of St//rings
	public void getAllWindows() {

		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();

		Iterator<String> I1 = s1.iterator();

		while (I1.hasNext()) {
			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}

			driver.switchTo().window(parent);

		}
	}

//	26.Switch to Frame by INDEX
	public void getFrameByIndex(int indexvalue) {
		driver.switchTo().frame(indexvalue);

	}

//  27.Switch to frame by frame ID

	public void getFramaeByFrameId(String frameId) {
		driver.switchTo().frame(frameId);
	}

//     28.Get All the Optiongs from DropDown 
	public String getAllOptionsByText(String attributeValue) {
		Select select = new Select(driver.findElement(By.id(attributeValue)));
		List<WebElement> optionList = select.getOptions();
		for (WebElement option : optionList) {
			System.out.println(option.getText());
		}
		return attributeValue;

	}

//   29.Get Option from DropDown by INDEX
	public String getAllOptionsByIndex(String attributeValue, int indexValue) {
		Select select = new Select(driver.findElement(By.id(attributeValue)));
		select.selectByIndex(indexValue);
		System.out.println(select.getFirstSelectedOption().getText());
		return attributeValue;

	}

//  29.Get Option from DropDown by VisibleTEXT

	public String getAllOptionsByText(String attributeValue, String text) {
		Select select = new Select(driver.findElement(By.id(attributeValue)));
		select.selectByVisibleText(text);
		System.out.println(select.getFirstSelectedOption().getText());
		return attributeValue;

	}

//	30.Get Option from DropDown by Value

	public String getAllOptionsByValue(String attributeValue, String value) {
		Select select = new Select(driver.findElement(By.id(attributeValue)));
		select.selectByValue(value);
		System.out.println(select.getFirstSelectedOption().getText());
		return attributeValue;

	}

//	31 Get First Selected Option in dropdown

	public WebElement firstSelectedOption(String attributeValue) {
		Select select = new Select(driver.findElement(By.id(attributeValue)));
		WebElement firstSelect = select.getFirstSelectedOption();
		return firstSelect;

	}

// 32.Verify Is dropdown IsMultiSelected

	public void isDropdownMultiSelected(String attributeValue, int indexValue, String value, String text) {
		Select select = new Select(driver.findElement(By.id(attributeValue)));
		if (select.isMultiple()) {

			select.selectByIndex(indexValue);
			select.selectByValue(value);
			select.selectByVisibleText(text);

		}
	}

// 33.  Get All Selected Options in dropdown	 

	public void allSelectedOptions(String attributeValue) {

		Select select = new Select(driver.findElement(By.id(attributeValue)));
		List<WebElement> selectedOptions = select.getAllSelectedOptions();

		for (WebElement selectedOption : selectedOptions)
			System.out.println(selectedOption.getText());

	}

//   34.Deselect Option from DropDown by INDEX
	public void deSelectOptionByIndex(String attributeValue, int indexValue) {

		Select select = new Select(driver.findElement(By.id(attributeValue)));
		select.deselectByIndex(indexValue);

	}

//   35.Deselect Option from DropDown by Value
	public void deSelectOptionByValue(String attributeValue, int value) {

		Select select = new Select(driver.findElement(By.id(attributeValue)));
		select.deselectByIndex(value);

	}

	// 36.Deselect Option from DropDown by TEXT
	public void deSelectOptionByText(String attributeValue, String text) {

		Select select = new Select(driver.findElement(By.id(attributeValue)));
		select.deselectByVisibleText(text);

	}

//   37.Implicit Wait
	public void implicitWait(long TimeOut) {

		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

	}

	// 38.Explicit Wait
	public void emplicitWait(WebDriver WebDriverRefrence, Duration TimeOut) {

		WebDriverWait wait = new WebDriverWait(WebDriverRefrence, TimeOut);

	}

	// 39. Delete ALL cookies

	public void deleteAllCookies() {

		driver.manage().deleteAllCookies();
	}

	// 40.Fluent Wait
	public void fluentWait(long SECONDS) {

		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(SECONDS))
				.pollingEvery(Duration.ofSeconds(SECONDS)).ignoring(Exception.class);

	}

//	41.IsDisplayed

	public boolean isDisplayed(String attributeValue) {

		WebElement element = driver.findElement(By.id(attributeValue));
		boolean status = element.isDisplayed();
		return status;

	}

//	42.IsEnabled

	public boolean isEnabled(String attributeValue) {

		WebElement element = driver.findElement(By.id(attributeValue));
		boolean status = element.isEnabled();
		return status;
	}

//	41.IsSelected

	public boolean isSelected(String attributeValue) {

		WebElement element = driver.findElement(By.id(attributeValue));
		boolean status = element.isSelected();
		return status;
	}

//	43.Deselect All

	public void deselectAll(Select ObjSelect) {

		ObjSelect.deselectAll();
	}

//	 44. Clear TextBox
	public void elementClear(WebElement element) {
		element.clear();
	}

//	 45.Take ScreenSHot

	public void takeScreenshot(TakesScreenshot webdriver, String fileWithPath) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

//	46.TakeScreenshot for Element

	public void elementScreenshot(WebElement element, String Filename, String expression) throws IOException {

		elementVisibility(element);
		WebElement element1 = driver.findElement(By.xpath(expression));

		File srcFile = element1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./target/" + Filename + ".png"));

	}

//	47.MouseOver Action for Single Option

	public void mouseOverAction(String attributeValue) {

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id(attributeValue)));

	}

//	48.RightClick

	public void rightClick(String attributeValue, WebElement btnElement) {

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id(attributeValue)));
		a.contextClick(btnElement).perform();

	}

//  49. Double CLick

	public void doubleClick(String attributeValue, WebElement btnElement) {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id(attributeValue)));
		doubleClick(attributeValue, btnElement);
	}

// 50.To Refersh the page

	public void toRefreshPage() {

		driver.navigate().refresh();
	}

// 51.get SIZE 
	public Dimension elementGetSize(WebElement element) {
		elementVisibility(element);
		Dimension text = element.getSize();
		return text;
	}

//  52.Actions using Build

	public void actionUsingBuild(Actions actions, WebDriver WebDriver) {
		Actions actions1 = new Actions(driver);
		Action action = actions1.build();
	}

//  53.Actions using perform

	public void actionUsingPerform(Actions actions, String attributeValue) {
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(driver.findElement(By.id(attributeValue)));
		actions1.build().perform();
	}

//  53.Actions using moveToElement

	public void moveToElement(Actions actions, String attributeValue) {
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(driver.findElement(By.id(attributeValue)));
		actions1.build().perform();
	}
//  54. click and Hold

	public void toClickAndHold(String attributeValue) {
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(driver.findElement(By.id(attributeValue)));
		actions1.moveByOffset(0, 400).perform();
	}

// 55.Drag And Drop
	private void dragAndDrop(WebElement src, WebElement trg) {
		Actions actions1 = new Actions(driver);
		actions1.dragAndDrop(src, trg).perform();
	}

	public void scrollDown() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
	}

// 56.Navigate Forward

	public void tonavigateForward() {
		driver.navigate().forward();
	}

// 57.Navigate Backward

	public void tonavigateBack() {
		driver.navigate().back();

	}

	public void toClickAndHold(WebElement scrollDown) {
		// TODO Auto-generated method stub

	}

	public static void enter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void sleep(long a) throws InterruptedException {
		Thread.sleep(a);
	}

//	63. FluentWait

//	private void FluentWait(Object WebDriver) {
//		
//		FluentWait wait = new FluentWait(WebDriver reference);
//				Object SECONDS;
//				wait.withTimeout(50, SECONDS);
//				wait.pollingEvery(50, SECONDS);
//				wait.ignoring(Exception.class);
//
//				WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
//				public WebElement applyy(WebDriver driver) {
//				return driver.findElement(By.id("foo"));
//				}
//				}
//	}
//	

}