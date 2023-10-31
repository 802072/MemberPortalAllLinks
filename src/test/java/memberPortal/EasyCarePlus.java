package memberPortal;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dataDriven.dataDriven;
import extentReport.BaseTest_AllLinks;
import extentReport.BaseTest_BLBI;

public class EasyCarePlus extends BaseTest_AllLinks {
	dataDriven d = new dataDriven();
	int colNum = 9;

	@BeforeSuite
	public void initializeReport() {
		initialiseExtentReports("MemberPortalAutomationEasyCarePlus.html",
				"Member Portal: EasyCare Plus Plan Automation Report");
	}

	public void loginECPlus() throws IOException, InterruptedException {
		ArrayList V70065532 = d.getData("V70065532", "loginCred");
		String healthPlan = (String) V70065532.get(5);
		String uname = (String) V70065532.get(1);
		String pswd = (String) V70065532.get(2);
		login(uname, pswd, healthPlan);
	}

	// Homepage
	@Test(groups = "Homepage")
	public void homePage() throws InterruptedException, IOException {

		loginECPlus();
		Thread.sleep(3000);

		// Verify Member's Name is Displayed
		assertEquals("HP0101", "homePage", colNum);

		// Verify Phone Number and Operation Hours are Displayed
		assertEquals("HP0119", "homePage", colNum);

		// Verify Health Plan is Displayed
		assertEquals("HP0120", "homePage", colNum);

		// Click Name
		clickElementJSExecute("HP0101", "homePage");
		driver.navigate().back();
		
		// Click View And Print ID Card
		clickElementJSExecute("HP0102", "homePage");
		verifyPageTitle("HP0102", "homePage", colNum);
		driver.navigate().back();
		
		// Click Check My Benefits
		clickElementJSExecute("HP0103", "homePage");
		verifyPageTitle("HP0103", "homePage", colNum);
		driver.navigate().back();
		
		// Click View My Care Team
		clickElementJSExecute("HP0104", "homePage");
		verifyPageTitle("HP0104", "homePage", colNum);
		driver.navigate().back();
		
		// Click Review My Medical Supplies
		clickElementJSExecute("HP0105", "homePage");
		verifyPageTitle("HP0105", "homePage", colNum);
		driver.navigate().back();
		
		// Click My Action Items
		clickElementJSExecute("HP0106", "homePage");
		verifyPageTitle("HP0106", "homePage", colNum);
		driver.navigate().back();
		
		// Click View Claims
		clickElementJSExecute("HP0107", "homePage");
		verifyPageTitle("HP0107", "homePage", colNum);
		driver.navigate().back();
		
		// Click View Service Authorizations
		clickElementJSExecute("HP0108", "homePage");
		verifyPageTitle("HP0108", "homePage", colNum);
		driver.navigate().back();
		
		// Click Rewards Link
		clickElementJSExecute("HP0112", "homePage");
		verifyPageTitle("HP0112", "homePage", colNum);
		driver.navigate().back();
		
		// Click Technical Support Link
		clickElementJSExecute("HP0109", "homePage");
		verifyPageTitle("HP0109", "homePage", colNum);
		driver.navigate().back();
		
		// Click Terms of Use Link
		openChildWindowVerifyTitle("HP0110", "homePage", colNum);
		// Click Privacy Policy Link
		openChildWindowVerifyTitle("HP0111", "homePage", colNum);

		submitFeedback("HP0115");
		
		// Click View 2024 Benefits Link
		//openChildWindowVerifyTitle("HP0121", "homePage", colNum);

	}

	// Benefits
	@Test(groups = "Benefits", priority = 1)
	public void benefits() throws InterruptedException, IOException {

		loginECPlus();
		// Click Benefits
		clickElementJSExecute("BE0101", "benefitsMenu");
		// Click Benefits Sub-menu
		clickElementJSExecute("BE0102", "benefitsMenu");
		verifyPageTitle("BE0102", "benefitsMenu", colNum);
		
		// Click View Summary of Benefits Link
		openChildWindowVerifyTitle("BE0108", "benefitsMenu", colNum);
		// Click View Evidence of Coverage Link
		openChildWindowVerifyTitle("BE0109", "benefitsMenu", colNum);
		// Click MedImpact Link
		openChildWindowVerifyTitle("BE0110", "benefitsMenu", colNum);
		// Click OTC and Grocery Card Link
		openChildWindowVerifyTitle("BE0111", "benefitsMenu", colNum);
		// Click Rewards Link
		openChildWindowVerifyTitle("BE0113", "benefitsMenu", colNum);
		// Click Carelon Link
		openChildWindowVerifyTitle("BE0114", "benefitsMenu", colNum);
		// Click Healthplex
		openChildWindowVerifyTitle("BE0105", "benefitsMenu", colNum);
		// Click Superior Vision
		openChildWindowVerifyTitle("BE0106", "benefitsMenu", colNum);
		// Click Click Modivcare
		openChildWindowVerifyTitle("BE0107", "benefitsMenu", colNum);
		// Click SilverSneakers Link
		openChildWindowVerifyTitle("BE0115", "benefitsMenu", colNum);
		Thread.sleep(5000);
	}

	// Pharmacy and Prescriptions
	@Test(groups = "Benefits")
	public void pharmacyAndPrescp() throws InterruptedException, IOException {

		loginECPlus();
		// Click Benefits Menu
		clickElementJSExecute("BE0201", "benefitsMenu");
		// Click Pharmacy And Prescriptions Sub-menu
		clickElementJSExecute("BE0202", "benefitsMenu");
		verifyPageTitle("BE0202", "benefitsMenu", colNum);
		// Click Go to MedImpact Link
		openChildWindowVerifyTitle("BE0203", "benefitsMenu", colNum);
		// Click Find a Medication Link
		openChildWindowVerifyTitle("BE0204", "benefitsMenu", colNum);
		// Click MedImpact Link
		openChildWindowVerifyTitle("BE0205", "benefitsMenu", colNum);
		// Click Formulary Link
		openChildWindowVerifyTitle("BE0206", "benefitsMenu", colNum);

	}

	// ID Card
	@Test(groups = "Benefits")
	public void idCard() throws InterruptedException, IOException {

		loginECPlus();
		// Click Benefits
		clickElementJSExecute("BE0301", "benefitsMenu");
		// Click ID Card Sub-menu
		clickElementJSExecute("BE0302", "benefitsMenu");
		verifyPageTitle("BE0302", "benefitsMenu", colNum);
		Thread.sleep(5000);
		// Click Communication Center
		clickElementJSExecute("BE0303", "benefitsMenu");
		verifyPageTitle("BE0303", "benefitsMenu", colNum);
		driver.navigate().back();
		// Click Return to Home
		clickElementJSExecute("BE0304", "benefitsMenu");

	}

	// OTC Benefits
	@Test(groups = "Benefits")
	public void otcBenefits() throws InterruptedException, IOException {

		loginECPlus();
		// Click Benefits Menu
		clickElementJSExecute("BE0401", "benefitsMenu");
		// Click OTC Benefits Sub-menu
		clickElementJSExecute("BE0402", "benefitsMenu");
		verifyPageTitle("BE0402", "benefitsMenu", colNum);
		// Click Go To Portal Link
		openChildWindowVerifyTitle("BE0403", "benefitsMenu", colNum);
		// Click Learn About OTC & Grocery Benefits Link
		openChildWindowVerifyTitle("BE0404", "benefitsMenu", colNum);
		// Click OTC and Grocery Card Link
		openChildWindowVerifyTitle("BE0405", "benefitsMenu", colNum);
	}

	// Rewards
	@Test(groups = "Benefits")
	public void rewards() throws InterruptedException, IOException {

		loginECPlus();
		// Click Benefits
		clickElementJSExecute("BE0601", "benefitsMenu");
		// Click Rewards Sub-menu
		clickElementJSExecute("BE0602", "benefitsMenu");
		verifyPageTitle("BE0602", "benefitsMenu", colNum);
		// Click Learn About Rewards Link
		openChildWindowVerifyTitle("BE0603", "benefitsMenu", colNum);
	}

	// Plan History
	@Test(groups = "Benefits")
	public void planHistory() throws InterruptedException, IOException {

		loginECPlus();
		// Click Benefits
		clickElementJSExecute("BE0701", "benefitsMenu");
		// Click planHistory Sub-menu
		clickElementJSExecute("BE0702", "benefitsMenu");
		verifyPageTitle("BE0702", "benefitsMenu", colNum);
	}

	// My Care
	// myPCP
	@Test(groups = "My Care")
	public void myPCP() throws InterruptedException, IOException {

		loginECPlus();
		// Click My Care Menu
		clickElementJSExecute("MC0101", "myCareMenu");
		// Click My PCP Sub-menu
		clickElementJSExecute("MC0102", "myCareMenu");
		verifyPageTitle("MC0102", "myCareMenu", colNum);
		// Click Provider Directory Link
		openChildWindowVerifyTitle("MC0103", "myCareMenu", colNum);
		// Click Request a PCP Change Link
		clickElementJSExecute("MC0104", "myCareMenu");
	}

	// myHealthPlanCareTeam
	@Test(groups = "My Care")
	public void myHealthPlanCareTeam() throws InterruptedException, IOException {

		loginECPlus();
		// Click My Care Menu
		clickElementJSExecute("MC0201", "myCareMenu");
		// Click myHealthPlanCareTeam Sub-menu
		clickElementJSExecute("MC0202", "myCareMenu");
		verifyPageTitle("MC0202", "myCareMenu", colNum);
		// Click Communication Center
		openChildWindowVerifyTitle("MC0203", "myCareMenu", colNum);

	}

	// serviceAuthorizations
	@Test(groups = "My Care")
	public void serviceAuthorizations() throws InterruptedException, IOException {

		loginECPlus();
		// Click My Care Menu
		clickElementJSExecute("MC0301", "myCareMenu");
		// Click serviceAuthorizationsSub-menu
		clickElementJSExecute("MC0302", "myCareMenu");
		verifyPageTitle("MC0302", "myCareMenu", colNum);
	}

	// My Medical Supplies and Equipment
	@Test(groups = "My Care")
	public void myMedicalSupp() throws InterruptedException, IOException {

		loginECPlus();
		// Click My Care Menu
		clickElementJSExecute("MC0401", "myCareMenu");
		// Click My Medica Supp Sub-menu
		clickElementJSExecute("MC0402", "myCareMenu");
		verifyPageTitle("MC0402", "myCareMenu", colNum);
	}

	// Claims
	// MyClaims
	@Test(groups = "Claims")
	public void claims() throws InterruptedException, IOException {

		loginECPlus();
		// Click Claims Menu
		clickElementJSExecute("CL0101", "claimsMenu");
		// Click My Claims Sub-menu
		clickElementJSExecute("CL0102", "claimsMenu");
		verifyPageTitle("CL0102", "claimsMenu", colNum);
		// Click Submit Reimbursement Request Link
		clickElementJSExecute("CL0103", "claimsMenu");
	}

	// Resources
	// My Plan Resources
	@Test(groups = "Resources")
	public void myPlanResources() throws InterruptedException, IOException {

		loginECPlus();
		// Click Resources Menu
		clickElementJSExecute("RE0101", "resourcesMenu");
		// Click My Plan Resources Sub-menu
		clickElementJSExecute("RE0102", "resourcesMenu");
		verifyPageTitle("RE0102", "resourcesMenu", colNum);
		
		// Click View All Resources Link
		openChildWindowVerifyTitle("RE0103", "resourcesMenu", colNum);
		// Click Member Rewards Program Link
		openChildWindowVerifyTitle("RE0108", "resourcesMenu", colNum);
		// Click OTC and Grocery Card Link
		openChildWindowVerifyTitle("RE0110", "resourcesMenu", colNum);
		// Click Transportation Link
		openChildWindowVerifyTitle("RE0104", "resourcesMenu", colNum);
		// Click Drug benefits and Resources Link
		openChildWindowVerifyTitle("RE0111", "resourcesMenu", colNum);
		// Click Medication Therapy Management Program Link
		openChildWindowVerifyTitle("RE0112", "resourcesMenu", colNum);
		// Click 2023 Plan Materials Link
		openChildWindowVerifyTitle("RE0113", "resourcesMenu", colNum);
		// Click Forms and Personal Health Materials Link
		openChildWindowVerifyTitle("RE0114", "resourcesMenu", colNum);
		// Click Frequently Asked Questions Link
		openChildWindowVerifyTitle("RE0107", "resourcesMenu", colNum);
	}

	// Benefit Partners
	@Test(groups = "Resources")
	public void benefitPartners() throws InterruptedException, IOException {

		loginECPlus();
		// Click Resources Menu
		clickElementJSExecute("RE0201", "resourcesMenu");
		// Click Benefit Partners Sub-menu
		clickElementJSExecute("RE0202", "resourcesMenu");
		verifyPageTitle("RE0202", "resourcesMenu", colNum);
		// Click MedImpact Link
		openChildWindowVerifyTitle("RE0206", "resourcesMenu", colNum);
		// Click OTC and Grocery Card Link
		openChildWindowVerifyTitle("RE0207", "resourcesMenu", colNum);
		// Click Rewards Link
		openChildWindowVerifyTitle("RE0209", "resourcesMenu", colNum);
		// Click Carelon Link
		openChildWindowVerifyTitle("RE0210", "resourcesMenu", colNum);
		// Click Healthplex
		openChildWindowVerifyTitle("RE0203", "resourcesMenu", colNum);
		// Click Superior Vision
		openChildWindowVerifyTitle("RE0204", "resourcesMenu", colNum);
		// Click Click Modivcare
		openChildWindowVerifyTitle("RE0205", "resourcesMenu", colNum);
		// Click SilverSneakers Link
		openChildWindowVerifyTitle("RE0211", "resourcesMenu", colNum);
	}

	// Grievances and Appeals
	// Grievances
	@Test(groups = "Grievances And Appeals")
	public void grievances() throws InterruptedException, IOException {

		loginECPlus();
		// Click Grievances and Appeals Menu
		clickElementJSExecute("GA0101", "grievancesMenu");
		// Click Grievances Sub-menu
		clickElementJSExecute("GA0102", "grievancesMenu");
		verifyPageTitle("GA0102", "grievancesMenu", colNum);
		// Click Learn About Complaints
		openChildWindowVerifyTitle("GA0103", "grievancesMenu", colNum);
	}

	// Appeals
	@Test(groups = "Grievances And Appeals")
	public void appeals() throws InterruptedException, IOException {

		loginECPlus();
		// Click Grievances and Appeals Menu
		clickElementJSExecute("GA0201", "grievancesMenu");
		// Click Grievances Sub-menu
		clickElementJSExecute("GA0202", "grievancesMenu");
		verifyPageTitle("GA0202", "grievancesMenu", colNum);
		// Click Learn About Appeals
		openChildWindowVerifyTitle("GA0203", "grievancesMenu", colNum);
	}

	// Communication Center
	@Test(groups = "Communication Center")
	public void communicationCenter() throws InterruptedException, IOException {

		loginECPlus();
		// Click Communication Center Menu
		clickElementJSExecute("CC0101", "comCenterMenu");
		// Click Communication Center Sub-menu
		clickElementJSExecute("CC0102", "comCenterMenu");
		verifyPageTitle("CC0102", "comCenterMenu", colNum);
		// Click Learn About Complaints
		clickElementJSExecute("CC0103", "comCenterMenu");

		driver.navigate().back();
		// Click Send a Message
		clickElementJSExecute("CC0104", "comCenterMenu");
	}

	// My Account
	@Test(groups = "My Account")
	public void myAccount() throws InterruptedException, IOException {

		loginECPlus();
		// Click My Account Menu
		clickElementJSExecute("MA0101", "myAccountMenu");
		// Click My Account Sub Menu
		clickElementJSExecute("MA0102", "myAccountMenu");
		verifyPageTitle("MA0102", "myAccountMenu", colNum);
		// Click Request Change
		clickElementJSExecute("MA0103", "myAccountMenu");
		// Click Cancel
		clickElementJSExecute("MA0104", "myAccountMenu");
		// Click Change Password
		clickElementJSExecute("MA0105", "myAccountMenu");

	}

}
