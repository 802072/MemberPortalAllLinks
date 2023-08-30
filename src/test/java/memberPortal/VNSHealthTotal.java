package memberPortal;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dataDriven.dataDriven;
import extentReport.BaseTest;

public class VNSHealthTotal extends BaseTest {
	dataDriven d = new dataDriven();

	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("MemberPortalAutomationTotal.html");
		sparkReporter_all.config().setReportName("Member Portal: VNS Health Total Plan Automation Report");

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Environment", "Test Environment");
	}

	// Homepage
	@Test(groups = "Homepage")
	public void homePage() throws InterruptedException, IOException {
		loginTotal();
		Thread.sleep(3000);
		// Click Name
		clickElement("HP0101", "homePage");
		driver.navigate().back();
		// Click View And Print ID Card
		clickElement("HP0102", "homePage");
		driver.navigate().back();
		// Click Check My Benefits
		clickElementJSExecute("HP0103", "homePage");
		driver.navigate().back();
		// Click View My Care Team
		clickElementJSExecute("HP0104", "homePage");
		driver.navigate().back();
		// Click Review My Medical Supplies
		clickElementJSExecute("HP0105", "homePage");
		driver.navigate().back();
		// Click My Action Items
		clickElementJSExecute("HP0106", "homePage");
		driver.navigate().back();
		// Click View Claims
		clickElementJSExecute("HP0107", "homePage");
		driver.navigate().back();
		// Click View Service Authorizations
		clickElementJSExecute("HP0108", "homePage");
		driver.navigate().back();
		// Click Rewards Link
		clickElementJSExecute("HP0112", "homePage");
		driver.navigate().back();
		// Click Technical Support Link
		clickElement("HP0109", "homePage");
		driver.navigate().back();
		// Click Terms of Use Link
		clickElementChildWindow("HP0110", "homePage");
		// Click Privacy Policy Link
		clickElementChildWindow("HP0111", "homePage");
	}

	// Benefits
	@Test(groups = "Benefits", priority = 1)
	public void benefits() throws InterruptedException, IOException {
		loginTotal();
		// Click Benefits
		clickElement("BE0101", "benefitsMenu");
		// Click Benefits Sub-menu
		clickElement("BE0102", "benefitsMenu");
		// Click View Summary of Benefits Link
		clickElementChildWindow("BE0108", "benefitsMenu");
		// Click View Evidence of Coverage Link
		clickElementChildWindow("BE0109", "benefitsMenu");
		// Click MedImpact Link
		clickElementChildWindow("BE0110", "benefitsMenu");
		// Click OTC and Grocery Card Link
		clickElementChildWindow("BE0111", "benefitsMenu");
		// Click Flex Card Link
		clickElementChildWindow("BE0112", "benefitsMenu");
		// Click Rewards Link
		clickElementChildWindow("BE0113", "benefitsMenu");
		// Click Carelon Link
		clickElementChildWindow("BE0114", "benefitsMenu");
		// Click Healthplex
		clickElementChildWindow("BE0105", "benefitsMenu");
		// Click Superior Vision
		clickElementChildWindow("BE0106", "benefitsMenu");
		// Click Click Modivcare
		clickElementChildWindow("BE0107", "benefitsMenu");
		// Click SilverSneakers Link
		clickElementChildWindow("BE0115", "benefitsMenu");
	}

	// Pharmacy and Prescriptions
	@Test(groups = "Benefits")
	public void pharmacyAndPrescp() throws InterruptedException, IOException {
		loginTotal();
		// Click Benefits Menu
		clickElement("BE0201", "benefitsMenu");
		// Click Pharmacy And Prescriptions Sub-menu
		clickElement("BE0202", "benefitsMenu");
		// Click Go to MedImpact Link
		clickElementChildWindow("BE0203", "benefitsMenu");
		// Click Find a Medication Link
		clickElementChildWindow("BE0204", "benefitsMenu");
		// Click MedImpact Link
		clickElementChildWindow("BE0205", "benefitsMenu");
		// Click Formulary Link
		clickElementChildWindow("BE0206", "benefitsMenu");

	}

	// ID Card
	@Test(groups = "Benefits")
	public void idCard() throws InterruptedException, IOException {
		loginTotal();
		// Click Benefits
		clickElement("BE0301", "benefitsMenu");
		// Click ID Card Sub-menu
		clickElement("BE0302", "benefitsMenu");
		Thread.sleep(5000);
		// Click Communication Center
		clickElement("BE0303", "benefitsMenu");
		driver.navigate().back();
		// Click Return to Home
		clickElement("BE0304", "benefitsMenu");

	}

	// OTC Benefits
	@Test(groups = "Benefits")
	public void otcBenefits() throws InterruptedException, IOException {
		loginTotal();
		// Click Benefits Menu
		clickElement("BE0401", "benefitsMenu");
		// Click OTC Benefits Sub-menu
		clickElement("BE0402", "benefitsMenu");
		// Click Go To Portal Link
		clickElementChildWindow("BE0403", "benefitsMenu");
		// Click Learn About OTC & Grocery Benefits Link
		clickElementChildWindow("BE0404", "benefitsMenu");
		// Click OTC and Grocery Card Link
		clickElementChildWindow("BE0405", "benefitsMenu");
	}

	// Flex Card
	@Test(groups = "Benefits")
	public void flexCard() throws InterruptedException, IOException {
		loginTotal();
		// Click Benefits Menu
		clickElement("BE0501", "benefitsMenu");
		// Click Flex Card Sub-menu
		clickElement("BE0502", "benefitsMenu");
		// Click Watch Video Link
		clickElementChildWindow("BE0503", "benefitsMenu");
		// Click Flex Card Link
		clickElementChildWindow("BE0504", "benefitsMenu");
	}

	// Rewards
	@Test(groups = "Benefits")
	public void rewards() throws InterruptedException, IOException {
		loginTotal();
		// Click Benefits
		clickElement("BE0601", "benefitsMenu");
		// Click Rewards Sub-menu
		clickElement("BE0602", "benefitsMenu");
		// Click Learn About Rewards Link
		clickElementChildWindow("BE0603", "benefitsMenu");
	}

	// Plan History
	@Test(groups = "Benefits")
	public void planHistory() throws InterruptedException, IOException {
		loginTotal();
		// Click Benefits
		clickElement("BE0701", "benefitsMenu");
		// Click planHistory Sub-menu
		clickElement("BE0702", "benefitsMenu");
	}

	// My Care
	// myPCP
	@Test(groups = "My Care")
	public void myPCP() throws InterruptedException, IOException {
		loginTotal();
		// Click My Care Menu
		clickElement("MC0101", "myCareMenu");
		// Click My PCP Sub-menu
		clickElement("MC0102", "myCareMenu");
		// Click Provider Directory Link
		clickElementChildWindow("MC0103", "myCareMenu");
		// Click Request a PCP Change Link
		clickElement("MC0104", "myCareMenu");
	}

	// myHealthPlanCareTeam
	@Test(groups = "My Care")
	public void myHealthPlanCareTeam() throws InterruptedException, IOException {
		loginTotal();
		// Click My Care Menu
		clickElement("MC0201", "myCareMenu");
		// Click myHealthPlanCareTeam Sub-menu
		clickElement("MC0202", "myCareMenu");
		// Click Communication Center
		clickElementChildWindow("MC0203", "myCareMenu");

	}

	// serviceAuthorizations
	@Test(groups = "My Care")
	public void serviceAuthorizations() throws InterruptedException, IOException {
		loginTotal();
		// Click My Care Menu
		clickElement("MC0301", "myCareMenu");
		// Click serviceAuthorizationsSub-menu
		clickElement("MC0302", "myCareMenu");
	}

	// My Medical Supplies and Equipment
	@Test(groups = "My Care")
	public void myMedicalSupp() throws InterruptedException, IOException {
		loginTotal();
		// Click My Care Menu
		clickElement("MC0401", "myCareMenu");
		// Click My Medical Supp Sub-menu
		clickElement("MC0402", "myCareMenu");
	}

	// Claims
	// MyClaims
	@Test(groups = "Claims")
	public void claims() throws InterruptedException, IOException {
		loginTotal();
		// Click Claims Menu
		clickElement("CL0101", "claimsMenu");
		// Click My Claims Sub-menu
		clickElement("CL0102", "claimsMenu");
		// Click Submit Reimbursement Request Link
		clickElementJSExecute("CL0103", "claimsMenu");
	}

	// Resources
	// My Plan Resources
	@Test(groups = "Resources")
	public void myPlanResources() throws InterruptedException, IOException {
		loginTotal();
		// Click Resources Menu
		clickElement("RE0101", "resourcesMenu");
		// Click My Plan Resources Sub-menu
		clickElement("RE0102", "resourcesMenu");
		// Click View All Resources Link
		clickElementChildWindow("RE0103", "resourcesMenu");

		// Click Member Rewards Program Link
		clickElementChildWindow("RE0108", "resourcesMenu");
		// Click Flex Card Link
		clickElementChildWindow("RE0109", "resourcesMenu");
		// Click OTC and Grocery Card Link
		clickElementChildWindow("RE0110", "resourcesMenu");
		// Click Transportation Link
		clickElementChildWindow("RE0104", "resourcesMenu");
		// Click Drug benefits and Resources Link
		clickElementChildWindow("RE0111", "resourcesMenu");
		// Click Medication Therapy Management Program Link
		clickElementChildWindow("RE0112", "resourcesMenu");
		// Click 2023 Plan Materials Link
		clickElementChildWindow("RE0113", "resourcesMenu");
		// Click Forms and Personal Health Materials Link
		clickElementChildWindow("RE0114", "resourcesMenu");
		// Click Frequently Asked Questions Link
		clickElementChildWindow("RE0107", "resourcesMenu");
	}

	// Benefit Partners
	@Test(groups = "Resources")
	public void benefitPartners() throws InterruptedException, IOException {
		loginTotal();
		// Click Resources Menu
		clickElement("RE0201", "resourcesMenu");
		// Click Benefit Partners Sub-menu
		clickElement("RE0202", "resourcesMenu");
		// Click MedImpact Link
		clickElementChildWindow("RE0206", "resourcesMenu");
		// Click OTC and Grocery Card Link
		clickElementChildWindow("RE0207", "resourcesMenu");
		// Click Flex Card Link
		clickElementChildWindow("RE0208", "resourcesMenu");
		// Click Rewards Link
		clickElementChildWindow("RE0209", "resourcesMenu");
		// Click Carelon Link
		clickElementChildWindow("RE0210", "resourcesMenu");
		// Click Healthplex
		clickElementChildWindow("RE0203", "resourcesMenu");
		// Click Superior Vision
		clickElementChildWindow("RE0204", "resourcesMenu");
		// Click Click Modivcare
		clickElementChildWindow("RE0205", "resourcesMenu");
		// Click SilverSneakers Link
		clickElementChildWindow("RE0211", "resourcesMenu");
	}

	// Grievances and Appeals
	// Grievances
	@Test(groups = "Grievances And Appeals")
	public void grievances() throws InterruptedException, IOException {
		loginTotal();
		// Click Grievances and Appeals Menu
		clickElement("GA0101", "grievancesMenu");
		// Click Grievances Sub-menu
		clickElement("GA0102", "grievancesMenu");
		// Click Learn About Complaints
		clickElementChildWindow("GA0103", "grievancesMenu");
	}

	// Appeals
	@Test(groups = "Grievances And Appeals")
	public void appeals() throws InterruptedException, IOException {
		loginTotal();
		// Click Grievances and Appeals Menu
		clickElement("GA0201", "grievancesMenu");
		// Click Grievances Sub-menu
		clickElement("GA0202", "grievancesMenu");
		// Click Learn About Appeals
		clickElementChildWindow("GA0203", "grievancesMenu");
	}

	// Communication Center
	@Test(groups = "Communication Center")
	public void communicationCenter() throws InterruptedException, IOException {
		loginTotal();
		// Click Communication Center Menu
		clickElement("CC0101", "comCenterMenu");
		// Click Communication Center Sub-menu
		clickElement("CC0102", "comCenterMenu");
		// Click Learn About Complaints
		clickElementJSExecute("CC0103", "comCenterMenu");

		driver.navigate().back();
		// Click Send a Message
		clickElement("CC0104", "comCenterMenu");
	}

	// My Account
	@Test(groups = "My Account")
	public void myAccount() throws InterruptedException, IOException {
		loginTotal();
		// Click My Account Menu
		clickElement("MA0101", "myAccountMenu");
		// Click My Account Sub Menu
		clickElement("MA0102", "myAccountMenu");
		// Click Request Change
		clickElement("MA0103", "myAccountMenu");
		// Click Cancel
		clickElement("MA0104", "myAccountMenu");
		// Click Change Password
		clickElement("MA0105", "myAccountMenu");

	}

	@AfterTest(alwaysRun = true)
	public void tearUp() {
		driver.close();
	}
}
