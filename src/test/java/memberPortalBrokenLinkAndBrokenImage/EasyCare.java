package memberPortalBrokenLinkAndBrokenImage;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import dataDriven.dataDriven;
import extentReport.BaseTest_BLBI;

public class EasyCare extends BaseTest_BLBI {
	dataDriven d = new dataDriven();

	public void loginEasyCare() throws IOException, InterruptedException {
		ArrayList V70040578 = d.getData("V70040578", "loginCred");
		String uname = (String) V70040578.get(1);
		String pswd = (String) V70040578.get(2);
		String healthPlan = (String) V70040578.get(5);
		login(uname, pswd, healthPlan);
	}

	@BeforeSuite
	public void initializeReport() {
		initialiseExtentReports("MemberPortalAutomationEasyCare_BLBI.html",
				"Member Portal: Easy Care Plan Broken Link and Image Test Report");
		System.out.println("Report Initialized");
	}

	// Homepage
	@Test(groups = "Homepage")
	public void homePage() throws InterruptedException, IOException {

		loginEasyCare();
		testBrokenImages();
		testBrokenLinks();
	}

	// Benefits
	@Test(groups = "Benefits", priority = 1)
	public void benefits() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Benefits
		clickElement("BE0101", "benefitsMenu");
		// Click Benefits Sub-menu
		clickElement("BE0102", "benefitsMenu");
		Thread.sleep(5000);
		testBrokenImages();
		testBrokenLinks();
	}

	// Pharmacy and Prescriptions
	@Test(groups = "Benefits")
	public void pharmacyAndPrescp() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Benefits Menu
		clickElement("BE0201", "benefitsMenu");
		// Click Pharmacy And Prescriptions Sub-menu
		clickElement("BE0202", "benefitsMenu");
		testBrokenImages();
		testBrokenLinks();

	}

	// ID Card
	@Test(groups = "Benefits")
	public void idCard() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Benefits
		clickElement("BE0301", "benefitsMenu");
		// Click ID Card Sub-menu
		clickElement("BE0302", "benefitsMenu");
		Thread.sleep(5000);
		testBrokenImages();
		testBrokenLinks();
	}

	// OTC Benefits
	@Test(groups = "Benefits")
	public void otcBenefits() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Benefits Menu
		clickElement("BE0401", "benefitsMenu");
		// Click OTC Benefits Sub-menu
		clickElement("BE0402", "benefitsMenu");
		testBrokenImages();
		testBrokenLinks();
	}

	// Rewards
	@Test(groups = "Benefits")
	public void rewards() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Benefits
		clickElement("BE0601", "benefitsMenu");
		// Click Rewards Sub-menu
		clickElement("BE0602", "benefitsMenu");
		testBrokenImages();
		testBrokenLinks();

	}

	// Plan History
	@Test(groups = "Benefits")
	public void planHistory() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Benefits
		clickElement("BE0701", "benefitsMenu");
		// Click planHistory Sub-menu
		clickElement("BE0702", "benefitsMenu");
		testBrokenImages();
		testBrokenLinks();
	}

	// My Care
	// myPCP
	@Test(groups = "My Care")
	public void myPCP() throws InterruptedException, IOException {

		loginEasyCare();
		// Click My Care Menu
		clickElement("MC0101", "myCareMenu");
		// Click My PCP Sub-menu
		clickElement("MC0102", "myCareMenu");
		testBrokenImages();
		testBrokenLinks();
	}

	// myHealthPlanCareTeam
	@Test(groups = "My Care")
	public void myHealthPlanCareTeam() throws InterruptedException, IOException {

		loginEasyCare();
		// Click My Care Menu
		clickElement("MC0201", "myCareMenu");
		// Click myHealthPlanCareTeam Sub-menu
		clickElement("MC0202", "myCareMenu");
		testBrokenImages();
		testBrokenLinks();

	}

	// serviceAuthorizations
	@Test(groups = "My Care")
	public void serviceAuthorizations() throws InterruptedException, IOException {

		loginEasyCare();
		// Click My Care Menu
		clickElement("MC0301", "myCareMenu");
		// Click serviceAuthorizationsSub-menu
		clickElement("MC0302", "myCareMenu");
		testBrokenImages();
		testBrokenLinks();
	}

	// My Medical Supplies and Equipment
	@Test(groups = "My Care")
	public void myMedicalSupp() throws InterruptedException, IOException {

		loginEasyCare();
		// Click My Care Menu
		clickElement("MC0401", "myCareMenu");
		// Click My Medical Supp Sub-menu
		clickElement("MC0402", "myCareMenu");
		testBrokenImages();
		testBrokenLinks();
	}

	// Claims
	// MyClaims
	@Test(groups = "Claims")
	public void claims() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Claims Menu
		clickElement("CL0101", "claimsMenu");
		// Click My Claims Sub-menu
		clickElement("CL0102", "claimsMenu");
		testBrokenImages();
		testBrokenLinks();

	}

	// Resources
	// My Plan Resources
	@Test(groups = "Resources")
	public void myPlanResources() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Resources Menu
		clickElement("RE0101", "resourcesMenu");
		// Click My Plan Resources Sub-menu
		clickElement("RE0102", "resourcesMenu");
		testBrokenImages();
		testBrokenLinks();
	}

	// Benefit Partners
	@Test(groups = "Resources")
	public void benefitPartners() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Resources Menu
		clickElement("RE0201", "resourcesMenu");
		// Click Benefit Partners Sub-menu
		clickElement("RE0202", "resourcesMenu");
		testBrokenImages();
		testBrokenLinks();
	}

	// Grievances and Appeals
	// Grievances
	@Test(groups = "Grievances And Appeals")
	public void grievances()  throws InterruptedException, IOException {

		loginEasyCare();
		// Click Grievances and Appeals Menu
		clickElement("GA0101", "grievancesMenu");
		// Click Grievances Sub-menu
		clickElement("GA0102", "grievancesMenu");
		testBrokenImages();
		testBrokenLinks();

	}

	// Appeals
	@Test(groups = "Grievances And Appeals")
	public void appeals() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Grievances and Appeals Menu
		clickElement("GA0201", "grievancesMenu");
		// Click Grievances Sub-menu
		clickElement("GA0202", "grievancesMenu");
		testBrokenImages();
		testBrokenLinks();

	}

	// Communication Center
	@Test(groups = "Communication Center")
	public void communicationCenter() throws InterruptedException, IOException {

		loginEasyCare();
		// Click Communication Center Menu
		clickElement("CC0101", "comCenterMenu");
		// Click Communication Center Sub-menu
		clickElement("CC0102", "comCenterMenu");
		testBrokenImages();
		testBrokenLinks();

	}

	// My Account
	@Test(groups = "My Account")
	public void myAccount() throws InterruptedException, IOException {

		loginEasyCare();
		// Click My Account Menu
		clickElement("MA0101", "myAccountMenu");
		// Click My Account Sub Menu
		clickElement("MA0102", "myAccountMenu");
		testBrokenImages();
		testBrokenLinks();

	}

	@AfterTest(alwaysRun = true)
	public void tearUp() {
		driver.close();
	}
}
