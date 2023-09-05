package memberPortal;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dataDriven.dataDriven;
import extentReport.BaseTest;

public class SelectHealth extends BaseTest {
	dataDriven d = new dataDriven();

	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("MemberPortalAutomationSelectHealth.html");
		sparkReporter_all.config().setReportName("Member Portal: Select Health Plan Automation Report");

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Environment", "Test Environment");
	}

	public void loginSelectHealth() throws IOException, InterruptedException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		String uname = (String) V80041737.get(1);
		String pswd = (String) V80041737.get(2);

		login(uname, pswd, hPlan);
	}

	// Homepage
	@Test(groups = "Homepage")
	public void homePage() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		Thread.sleep(3000);
		// Click Name
		clickElement("HP0101", "homePage", hPlan);
		driver.navigate().back();
		// Click View And Print ID Card
		clickElement("HP0102", "homePage", hPlan);
		driver.navigate().back();
		// Click Check My Benefits
		clickElementJSExecute("HP0103", "homePage", hPlan);
		driver.navigate().back();
		// Click View My Care Team
		clickElementJSExecute("HP0104", "homePage", hPlan);
		driver.navigate().back();
		// Click Review My Medical Supplies
		clickElementJSExecute("HP0105", "homePage", hPlan);
		driver.navigate().back();
		// Click My Action Items
		clickElementJSExecute("HP0106", "homePage", hPlan);
		driver.navigate().back();
		// Click View Claims
		clickElementJSExecute("HP0107", "homePage", hPlan);
		driver.navigate().back();
		// Click View Service Authorizations
		clickElementJSExecute("HP0108", "homePage", hPlan);
		driver.navigate().back();
		// Click Rewards Link
		clickElementJSExecute("HP0112", "homePage", hPlan);
		driver.navigate().back();
		// Click Technical Support Link
		clickElement("HP0109", "homePage", hPlan);
		driver.navigate().back();
		// Click Terms of Use Link
		clickElementChildWindow("HP0110", "homePage", hPlan);
		// Click Privacy Policy Link
		clickElementChildWindow("HP0111", "homePage", hPlan);

	}

	// Benefits
	@Test(groups = "Benefits", priority = 1)
	public void benefits() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Benefits
		clickElement("BE0101", "benefitsMenu", hPlan);
		// Click Benefits Sub-menu
		clickElement("BE0102", "benefitsMenu", hPlan);

		// Click Member Handbook Link (this page)
		clickElementChildWindow("BE0116", "benefitsMenu", hPlan);

		// Click Carelon Link
		clickElementChildWindow("BE0114", "benefitsMenu", hPlan);
		// Click Healthplex
		clickElementChildWindow("BE0105", "benefitsMenu", hPlan);
		// Click Superior Vision
		clickElementChildWindow("BE0106", "benefitsMenu", hPlan);
	}

	// ID Card
	@Test(groups = "Benefits")
	public void idCard() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Benefits
		clickElement("BE0301", "benefitsMenu", hPlan);
		// Click ID Card Sub-menu
		clickElement("BE0302", "benefitsMenu", hPlan);
		Thread.sleep(5000);
		// Click Communication Center
		clickElement("BE0303", "benefitsMenu", hPlan);
		driver.navigate().back();
		// Click Return to Home
		clickElement("BE0304", "benefitsMenu", hPlan);

	}

	// Rewards
	@Test(groups = "Benefits")
	public void rewards() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Benefits
		clickElement("BE0601", "benefitsMenu", hPlan);
		// Click Rewards Sub-menu
		clickElement("BE0602", "benefitsMenu", hPlan);

		// Click Download Brochure Link
		clickElementChildWindow("BE0604", "benefitsMenu", hPlan);
	}

	// Plan History
	@Test(groups = "Benefits")
	public void planHistory() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Benefits
		clickElement("BE0701", "benefitsMenu", hPlan);
		// Click planHistory Sub-menu
		clickElement("BE0702", "benefitsMenu", hPlan);
	}

	// My Care
	// myPCP
	@Test(groups = "My Care")
	public void myPCP() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click My Care Menu
		clickElement("MC0101", "myCareMenu", hPlan);
		// Click My PCP Sub-menu
		clickElement("MC0102", "myCareMenu", hPlan);
		// Click Provider Directory Link
		clickElementChildWindow("MC0103", "myCareMenu", hPlan);
		// Click Request a PCP Change Link
		clickElementJSExecute("MC0104", "myCareMenu", hPlan);
	}

	// myHealthPlanCareTeam
	@Test(groups = "My Care")
	public void myHealthPlanCareTeam() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click My Care Menu
		clickElement("MC0201", "myCareMenu", hPlan);
		// Click myHealthPlanCareTeam Sub-menu
		clickElement("MC0202", "myCareMenu", hPlan);
		// Click Communication Center
		clickElementChildWindow("MC0203", "myCareMenu", hPlan);

	}

	// serviceAuthorizations
	@Test(groups = "My Care")
	public void serviceAuthorizations() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click My Care Menu
		clickElement("MC0301", "myCareMenu", hPlan);
		// Click serviceAuthorizationsSub-menu
		clickElement("MC0302", "myCareMenu", hPlan);
	}

	// My Medical Supplies and Equipment
	@Test(groups = "My Care")
	public void myMedicalSupp() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click My Care Menu
		clickElement("MC0401", "myCareMenu", hPlan);
		// Click My Medica Supp Sub-menu
		clickElement("MC0402", "myCareMenu", hPlan);
	}

	// Claims
	// MyClaims
	@Test(groups = "Claims")
	public void claims() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Claims Menu
		clickElement("CL0101", "claimsMenu", hPlan);
		// Click My Claims Sub-menu
		clickElement("CL0102", "claimsMenu", hPlan);
		// Click Submit Reimbursement Request Link
		clickElementJSExecute("CL0103", "claimsMenu", hPlan);
	}

	// Resources
	// My Plan Resources
	@Test(groups = "Resources")
	public void myPlanResources() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Resources Menu
		clickElement("RE0101", "resourcesMenu", hPlan);
		// Click My Plan Resources Sub-menu
		clickElement("RE0102", "resourcesMenu", hPlan);

		// Click Transgender Health Services Link
		clickElementChildWindow("RE0115", "resourcesMenu", hPlan);
		// Click HIV Resources Link
		clickElementChildWindow("RE0116", "resourcesMenu", hPlan);
		// Click Reources for Homeless Individuals Link
		clickElementChildWindow("RE0117", "resourcesMenu", hPlan);
		// Click Home & Community-Based Services Link
		clickElementChildWindow("RE0118", "resourcesMenu", hPlan);
		// Click Provider Search Link
		clickElementChildWindow("RE0119", "resourcesMenu", hPlan);
		// Click Member Forms & Materials Link
		clickElementChildWindow("RE0120", "resourcesMenu", hPlan);

	}

	// Benefit Partners
	@Test(groups = "Resources")
	public void benefitPartners() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Resources Menu
		clickElement("RE0201", "resourcesMenu", hPlan);
		// Click Benefit Partners Sub-menu
		clickElement("RE0202", "resourcesMenu", hPlan);

		// Click Carelon Link
		clickElementChildWindow("RE0210", "resourcesMenu", hPlan);
		// Click Healthplex
		clickElementChildWindow("RE0203", "resourcesMenu", hPlan);
		// Click Superior Vision
		clickElementChildWindow("RE0204", "resourcesMenu", hPlan);
	}

	// Grievances and Appeals
	// Grievances
	@Test(groups = "Grievances And Appeals")
	public void grievances() throws InterruptedException, IOException {
		ArrayList<String> V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Grievances and Appeals Menu
		clickElement("GA0101", "grievancesMenu", hPlan);
		// Click Grievances Sub-menu
		clickElement("GA0102", "grievancesMenu", hPlan);
		// Click Learn About Complaints
		clickElementChildWindow("GA0103", "grievancesMenu", hPlan);
	}

	// Appeals
	@Test(groups = "Grievances And Appeals")
	public void appeals() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Grievances and Appeals Menu
		clickElement("GA0201", "grievancesMenu", hPlan);
		// Click Grievances Sub-menu
		clickElement("GA0202", "grievancesMenu", hPlan);
		// Click Learn About Appeals
		clickElementChildWindow("GA0203", "grievancesMenu", hPlan);
	}

	// Communication Center
	@Test(groups = "Communication Center")
	public void communicationCenter() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click Communication Center Menu
		clickElement("CC0101", "comCenterMenu", hPlan);
		// Click Communication Center Sub-menu
		clickElement("CC0102", "comCenterMenu", hPlan);
		// Click Learn About Complaints
		clickElementJSExecute("CC0103", "comCenterMenu", hPlan);

		driver.navigate().back();
		// Click Send a Message
		clickElement("CC0104", "comCenterMenu", hPlan);
	}

	// My Account
	@Test(groups = "My Account")
	public void myAccount() throws InterruptedException, IOException {
		ArrayList V80041737 = d.getData("V80041737", "loginCred");
		String hPlan = (String) V80041737.get(5);
		loginSelectHealth();
		// Click My Account Menu
		clickElement("MA0101", "myAccountMenu", hPlan);
		// Click My Account Sub Menu
		clickElement("MA0102", "myAccountMenu", hPlan);
		// Click Request Change
		clickElement("MA0103", "myAccountMenu", hPlan);
		// Click Cancel
		clickElement("MA0104", "myAccountMenu", hPlan);
		// Click Change Password
		clickElement("MA0105", "myAccountMenu", hPlan);

	}

	@AfterTest(alwaysRun = true)
	public void tearUp() {
		driver.close();
	}
}
