package extentReport;

import java.io.*;

import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.file.UnableSaveSnapshotException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import dataDriven.dataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class BaseTest {
	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentTest testStepExtentTest;
	dataDriven d = new dataDriven();

	@Parameters("browserName")
	@BeforeTest
	public void setup(ITestContext context, @Optional("chrome") String browserName)
			throws IOException, InterruptedException {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			break;

		case "edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();

			break;

		}

		extentTest = extentReports.createTest(context.getName());
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName1 = cap.getBrowserName();
		String v = cap.getBrowserVersion().toString();

		// extentTest.assignAuthor(author);
		// extentTest.assignDevice(device);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public void login (String username, String password, String healthPlan) throws InterruptedException, IOException {		
		// get login page
		ArrayList TS01 = d.getData("LI01", "loginSteps");
		String loginPage = (String) TS01.get(6);
		driver.get(loginPage);
		Thread.sleep(6000);
		
		extentTest.log(Status.PASS, "Get Login Page. URL is " + loginPage,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Loginpage" + ".jpg")).build());
		
		// enter username
		ArrayList TS02 = d.getData("LI02", "loginSteps");
		WebElement uname = driver.findElement(By.xpath((String) TS02.get(5)));
		uname.sendKeys(username);
		extentTest.log(Status.PASS, "Enter Username: " + username + ", Health Plan: "+ healthPlan,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("username" + ".jpg")).build());

		// enter password
		ArrayList TS03 = d.getData("LI03", "loginSteps");
		WebElement pwd = driver.findElement(By.xpath((String) TS03.get(5)));
		pwd.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extentTest.log(Status.PASS, "Enter Password",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("password" + ".jpg")).build());

		// login
		ArrayList TS04 = d.getData("LI04", "loginSteps");
		WebElement signOn = driver.findElement(By.xpath((String) TS04.get(5)));
		signOn.click();
		extentTest.log(Status.PASS, "Click Sign On",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("signon" + ".jpg")).build());

		// enter password
		WebElement pwd1 = driver.findElement(By.xpath((String) TS03.get(5)));
		pwd1.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extentTest.log(Status.PASS, "Enter Password",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("password1" + ".jpg")).build());

		// login
		extentTest.log(Status.PASS, "Click Sign On",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("signon1" + ".jpg")).build());
		WebElement signOn1 = driver.findElement(By.xpath((String) TS04.get(5)));
		signOn1.click();
		Thread.sleep(5000);
	}
	
	public void loginMLTC() throws IOException, InterruptedException {
		
		ArrayList V80209467 = d.getData("V80209467", "loginCred");
		String uname = (String) V80209467.get(1);
		String pswd = (String) V80209467.get(2);
		String hPlan = (String) V80209467.get(5);
		login(uname, pswd, hPlan);
		}

	public void loginTotal() throws IOException, InterruptedException {
		
		ArrayList V70069794 = d.getData("V70069794", "loginCred");
		String uname = (String) V70069794.get(1);
		String pswd = (String) V70069794.get(2);
		String hPlan = (String) V70069794.get(5);
		login(uname, pswd, hPlan);
		}
	
	public void loginECPlus() throws IOException, InterruptedException {
		ArrayList V70065532 = d.getData("V70065532", "loginCred");
		String uname = (String) V70065532.get(1);
		String pswd = (String) V70065532.get(2);
		String hPlan = (String) V70065532.get(5);
		login(uname, pswd, hPlan);
		}
	
	public void loginSelectHealth() throws IOException, InterruptedException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String uname = (String) V80041737.get(1);
		String pswd = (String) V80041737.get(2);
		String hPlan = (String) V80041737.get(5);
		login(uname, pswd, hPlan);
		}
	
	public void loginEasyCare() throws IOException, InterruptedException {
		ArrayList V70040578 = d.getData("V70040578", "loginCred");
		String uname = (String) V70040578.get(1);
		String pswd = (String) V70040578.get(2);
		String hPlan = (String) V70040578.get(5);
		login(uname, pswd, hPlan);
		}
	
	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("MemberPortalAutomation.html");
		sparkReporter_all.config().setReportName("Member Portal Automation Report");
		// Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Environment", "Test Environment");
		// extentReports.setSystemInfo("Browser Name", cap.getBrowserName()+ "
		// "+cap.getVersion());
		// extentReports.setSystemInfo("Environment", "Production Environment");
		// excelWR.createSheet();
	}
	
	public void clickElement(String rowName, String sheetName) throws IOException, InterruptedException {
	ArrayList list = d.getData(rowName, sheetName);
	WebElement element = driver.findElement(By.xpath((String) list.get(6)));
	element.click();
	Thread.sleep(6000);
	extentTest.log(Status.PASS, (String) list.get(2),
			MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(rowName + ".jpg")).build());
	}
	
	public void clickElementChildWindow(String rowName, String sheetName) throws IOException, InterruptedException {
	ArrayList list = d.getData(rowName, sheetName);
	WebElement element = driver.findElement(By.xpath((String) list.get(6)));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	Thread.sleep(3000);
	String parentHandle = driver.getWindowHandle();
	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
		
	}
	
	Thread.sleep(5000);
	extentTest.log(Status.PASS, (String) list.get(2),
			MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(rowName + ".jpg")).build());
	driver.close();
	driver.switchTo().window(parentHandle); 
	Thread.sleep(5000);
	}
	
	public void clickElementJSExecute(String rowName, String sheetName) throws IOException, InterruptedException {
	ArrayList list = d.getData(rowName, sheetName);
	WebElement element = driver.findElement(By.xpath((String) list.get(6)));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	//element.click();
	Thread.sleep(3000);
	extentTest.log(Status.PASS, (String) list.get(2),
			MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(rowName + ".jpg")).build());
	}
	
	@AfterSuite
	public void generateExtentReports() throws Exception {
		extentReports.flush();
		// Desktop.getDesktop().browse(new File("ProviderPortalTests.html").toURI());
		// Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		// excelWR.writeIntoExcel();
	}

	@AfterMethod
	public void checkStatus(Method m, ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotpath = null;
			screenshotpath = captureScreenshot("failTest.jpg");
			extentTest.fail(m.getName() + " has failed");
			extentTest.log(Status.FAIL, result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}
		if (result.getStatus() == ITestResult.SKIP) {

			String screenshotpath = null;
			screenshotpath = captureScreenshot("skipTest.jpg");
			extentTest.skip(m.getName() + " has skipped");
			extentTest.log(Status.SKIP, result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {

		}

		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}


	public String captureScreenshot(String screenShotName) throws IOException {

		// Shutterbug Working Code
		Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
		BufferedImage image = Shutterbug.shootPage(driver, Capture.FULL, true).getImage();
		String dest = "./screenshots/" + screenShotName;
		writeImage(image, "PNG", new File(dest));
		return dest;
	}

	public static void writeImage(BufferedImage imageFile, String extension, File fileToWriteTo) {
		try {
			ImageIO.write(imageFile, extension, fileToWriteTo);
		} catch (IOException e) {
			throw new UnableSaveSnapshotException(e);
		}
	}

}