package memberPortalBrokenLinkAndBrokenImage;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dataDriven.dataDriven;
import extentReport.BaseTest_BLBI;

public class VNSHealthMLTC extends BaseTest_BLBI {
	dataDriven d = new dataDriven();

	@BeforeSuite
	public void initializeReport() {
		initialiseExtentReports("MemberPortalAutomationMLTC_BLBI.html",
				"Member Portal: VNS Health MLTC Plan Automation Report");
	}

	public void loginMLTC() throws IOException, InterruptedException {
		ArrayList V80209467 = d.getData("V80209467", "loginCred");
		String uname = (String) V80209467.get(1);
		String pswd = (String) V80209467.get(2);
		String healthPlan = (String) V80209467.get(5);
		login(uname, pswd, healthPlan);
	}

	// Homepage
	@Test(groups = "Homepage")
	public void homePage() throws InterruptedException, IOException {

		loginMLTC();
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// Benefits
	@Test(groups = "Benefits", priority = 1)
	public void benefits() throws InterruptedException, IOException {

		loginMLTC();
		// Click Benefits
		clickElement("BE0101", "benefitsMenu");
		// Click Benefits Sub-menu
		clickElement("BE0102", "benefitsMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// ID Card
	@Test(groups = "Benefits")
	public void idCard() throws InterruptedException, IOException {

		loginMLTC();
		// Click Benefits
		clickElement("BE0301", "benefitsMenu");
		// Click ID Card Sub-menu
		clickElement("BE0302", "benefitsMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();

	}

	// Plan History
	@Test(groups = "Benefits")
	public void planHistory() throws InterruptedException, IOException {

		loginMLTC();
		// Click Benefits
		clickElement("BE0701", "benefitsMenu");
		// Click planHistory Sub-menu
		clickElement("BE0702", "benefitsMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// My Care
	// myHealthPlanCareTeam
	@Test(groups = "My Care")
	public void myHealthPlanCareTeam() throws InterruptedException, IOException {

		loginMLTC();
		// Click My Care Menu
		clickElement("MC0201", "myCareMenu");
		// Click myHealthPlanCareTeam Sub-menu
		clickElement("MC0202", "myCareMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// serviceAuthorizations
	@Test(groups = "My Care")
	public void serviceAuthorizations() throws InterruptedException, IOException {

		loginMLTC();
		// Click My Care Menu
		clickElement("MC0301", "myCareMenu");
		// Click serviceAuthorizationsSub-menu
		clickElement("MC0302", "myCareMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// My Medical Supplies and Equipment
	@Test(groups = "My Care")
	public void myMedicalSupp() throws InterruptedException, IOException {

		loginMLTC();
		// Click My Care Menu
		clickElement("MC0401", "myCareMenu");
		// Click My Medica Supp Sub-menu
		clickElement("MC0402", "myCareMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// Claims
	// MyClaims
	@Test(groups = "Claims")
	public void claims() throws InterruptedException, IOException {

		loginMLTC();
		// Click Claims Menu
		clickElement("CL0101", "claimsMenu");
		// Click My Claims Sub-menu
		clickElement("CL0102", "claimsMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// Resources
	// My Plan Resources
	@Test(groups = "Resources")
	public void myPlanResources() throws InterruptedException, IOException {

		loginMLTC();
		// Click Resources Menu
		clickElement("RE0101", "resourcesMenu");
		// Click My Plan Resources Sub-menu
		clickElement("RE0102", "resourcesMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// Benefit Partners
	@Test(groups = "Resources")
	public void benefitPartners() throws InterruptedException, IOException {

		loginMLTC();
		// Click Resources Menu
		clickElement("RE0201", "resourcesMenu");
		// Click Benefit Partners Sub-menu
		clickElement("RE0202", "resourcesMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// Grievances and Appeals
	// Grievances
	@Test(groups = "Grievances and Appeals")
	public void grievances() throws InterruptedException, IOException {

		loginMLTC();
		// Click Grievances and Appeals Menu
		clickElement("GA0101", "grievancesMenu");
		// Click Grievances Sub-menu
		clickElement("GA0102", "grievancesMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// Appeals
	@Test(groups = "Grievances and Appeals")
	public void appeals() throws InterruptedException, IOException {

		loginMLTC();
		// Click Grievances and Appeals Menu
		clickElement("GA0201", "grievancesMenu");
		// Click Appeals Sub-menu
		clickElement("GA0202", "grievancesMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// Communication Center
	@Test(groups = "Communication Center")
	public void communicationCenter() throws InterruptedException, IOException {

		loginMLTC();
		// Click Communication Center Menu
		clickElement("CC0101", "comCenterMenu");
		// Click Communication Center Sub-menu
		clickElement("CC0102", "comCenterMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();
	}

	// My Account
	@Test(groups = "My Account")
	public void myAccount() throws InterruptedException, IOException {

		loginMLTC();
		// Click My Account Menu
		clickElement("MA0101", "myAccountMenu");
		// Click My Account Sub Menu
		clickElement("MA0102", "myAccountMenu");
		Thread.sleep(3000);
		testBrokenImages();
		testBrokenLinks();

	}

	@AfterTest(alwaysRun = true)
	public void tearUp() {
		driver.close();
	}
}
