package extentReport;

import java.io.*;

import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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
import com.aventstack.extentreports.reporter.configuration.Theme;

import dataDriven.dataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.interactions.Actions;

public class BaseTest_AllLinks {
	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentTest testStepExtentTest;

	dataDriven d = new dataDriven();
	Date date = new Date();
	String fileDate = date.toString().replace(":", "_").replace(" ", "_");

	public void initialiseExtentReports(String reportName, String reportTitle) {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter(reportName);
		sparkReporter_all.config().setReportName(reportTitle);
		sparkReporter_all.config().setTheme(Theme.STANDARD);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		// extentReports.setSystemInfo("Environment", "Test Environment");

	}

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

		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String device = capabilities.getBrowserName().toUpperCase() + " "
				+ capabilities.getBrowserVersion().substring(0, capabilities.getBrowserVersion().indexOf("."));
		// String author = context.getCurrentXmlTest().getParameter("author");

		extentTest = extentReports.createTest(context.getName());

		// extentTest.assignAuthor(author);
		extentTest.assignDevice(device);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@SuppressWarnings("deprecation")
	public void login(String username, String password, String healthPlan) throws InterruptedException, IOException {
		// get login page
		ArrayList<?> TS01 = d.getData("LI01", "loginSteps");
		String loginPage = (String) TS01.get(6);
		driver.get(loginPage);
		Thread.sleep(6000);
		extentTest.log(Status.PASS, (String) TS01.get(1) + " URL is: " + loginPage, MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("Loginpage" + fileDate + ".jpg")).build());

		try{
		// enter username
		sendKeys("LI02", "loginSteps", username);
		// log username and health plan
		extentTest.log(Status.PASS, "Username is: " + username + ", Health Plan is: " + healthPlan, MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("username" + fileDate + ".jpg")).build());
		
		} catch (Exception e) {
			
		}
		// enter password
		sendKeys("LI03", "loginSteps", password);
		// click login
		clickElementLogin("LI04", "loginSteps");
		// re-enter password
		sendKeys("LI03", "loginSteps", password);
		// Sign on
		clickElementLogin("LI04", "loginSteps");
	}

	public void clickElement(String rowName, String sheetName) throws IOException, InterruptedException {
		ArrayList<?> list = d.getData(rowName, sheetName);
		WebElement element = driver.findElement(By.xpath((String) list.get(6)));
		element.click();
		Thread.sleep(6000);
		extentTest.log(Status.PASS, (String) list.get(2),
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(rowName + fileDate + ".jpg")).build());
	}

	public void clickElementLogin(String rowName, String sheetName) throws IOException, InterruptedException {
		ArrayList<?> list = d.getData(rowName, sheetName);
		WebElement element = driver.findElement(By.xpath((String) list.get(5)));
		element.click();
		Thread.sleep(6000);
		extentTest.log(Status.PASS, (String) list.get(1), MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("click sign on" + fileDate + ".jpg")).build());
	}

	public void clickElementChildWindow(String rowName, String sheetName) throws IOException, InterruptedException {
		ArrayList<?> list = d.getData(rowName, sheetName);
		WebElement element = driver.findElement(By.xpath((String) list.get(6)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		String parentHandle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(5000);
		extentTest.log(Status.PASS, (String) list.get(2),
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(rowName + fileDate + ".jpg")).build());
	
		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(5000);
	}

	public void clickElementJSExecute(String rowName, String sheetName) throws IOException, InterruptedException {
		ArrayList<?> list = d.getData(rowName, sheetName);
		WebElement element = driver.findElement(By.xpath((String) list.get(6)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		extentTest.log(Status.PASS, (String) list.get(2),
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(rowName + fileDate + ".jpg")).build());
	}

	@SuppressWarnings("deprecation")
	public void sendKeys(String rowName, String sheetName, String value) throws IOException {
		ArrayList<?> list = d.getData(rowName, sheetName);
		WebElement inputElement = driver.findElement(By.xpath((String) list.get(5)));
		inputElement.sendKeys(value);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extentTest.log(Status.PASS, (String) list.get(1), MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("password" + fileDate + ".jpg")).build());
	}

	@AfterSuite
	public void generateExtentReports() throws Exception {
		extentReports.flush();
		System.out.println("Report Generated");
		// Desktop.getDesktop().browse(new File(".html").toURI());
		// Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
	}

	@AfterMethod
	public void checkStatus(Method m, ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(m.getName() + " has failed");
			extentTest.log(Status.FAIL, result.getThrowable(), MediaEntityBuilder
					.createScreenCaptureFromPath(captureScreenshot(m.getName() + fileDate + ".jpg")).build());
		}
		if (result.getStatus() == ITestResult.SKIP) {
			extentTest.skip(m.getName() + " has skipped");
			extentTest.log(Status.SKIP, result.getThrowable(), MediaEntityBuilder
					.createScreenCaptureFromPath(captureScreenshot(m.getName() + fileDate + ".jpg")).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " has passed");
		}

		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}

	public String captureScreenshot(String screenShotName) throws IOException {
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

	public void submitFeedback(String smileyRowNum) throws IOException, InterruptedException {
		// Click Feedback Slider
		clickElementJSExecute("HP0113", "homePage");
		// Switch to survey iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@name='survey-iframe-SI_6LszIRnZhItizxY']"));
		driver.switchTo().frame(iframe);
		// Click Smiley
		clickElement(smileyRowNum, "homePage");
//		WebElement input= findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
		
//		WebElement input= findElement(By.xpath("//input[@aria-labelledby='question-display-QID104']"));
//		Actions action = new Actions (driver);
		//action.moveToElement(input).click().perform();	
		
		//System.out.println("clicked input");
//		input.sendKeys(Keys.DELETE);
//		input.sendKeys("test");
		//qn.getText();
		//System.out.println("VALUE OF QN IS: "+qn.getText());
		//if (input.isDisplayed()) {
			
		//	input.sendKeys("Test Feedback");
		//}	
		//else {
		//System.out.println("input field not available");
		//}
		// Click Submit Button
		clickElement("HP0117", "homePage");
		driver.switchTo().defaultContent();
		// Click Feedback Slider
		clickElementJSExecute("HP0113", "homePage");
	}

	public void assertEquals(String rowName, String sheetName) throws InterruptedException, IOException {
		ArrayList list = d.getData(rowName, sheetName);
		Assert.assertEquals(driver.findElement(By.xpath((String) list.get(6))).getText(), (String) list.get(7));
		Thread.sleep(10000);
		extentTest.log(Status.PASS, (String)list.get(2), MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot(rowName + sheetName + fileDate + ".jpg")).build());
	}
	
public void assertIsDisplayed(String rowName, String sheetName) throws IOException {
	
	ArrayList<?> list = d.getData(rowName, sheetName);
	WebElement element = driver.findElement(By.xpath((String) list.get(6)));
	String elementText= element.getText();
	
	Assert.assertEquals((element).isDisplayed(), true);
	
	//log
	extentTest.log(Status.PASS, "Verify Element is Displayed. Actual Value is: "+ elementText,
			MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(rowName + fileDate + ".jpg")).build());
	
	System.out.println("Text Value is: "+ element.getText());
}

public void verifyPageTitle(String rowName, String sheetName) throws IOException {
	ArrayList<?> list = d.getData(rowName, sheetName);
	String pageTitle= driver.getTitle();
	Assert.assertEquals(pageTitle, (String) list.get(7));
	//log
	extentTest.log(Status.PASS, "Verify Page Title is "+(String) list.get(7)+"."+  " Actual Title is: "+ pageTitle,
			MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(rowName + fileDate + ".jpg")).build());
	System.out.println("TITLE IS : "+pageTitle);
}

}