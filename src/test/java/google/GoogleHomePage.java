package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageElement;

public class GoogleHomePage {
	private static final String PROPERTY_ROOT_DIR = System.getProperty("user.dir");
	WebDriver driver = null;
	ExtentTest test;
	ExtentReports extent;

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver()/* .version("2.36") */.setup();
		driver = new ChromeDriver();
		// initialize ExtentReports and attach the HtmlReporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(PROPERTY_ROOT_DIR + "/test-output/testReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@Test
	public void googleSearch() {
		test = extent.createTest("Google Search Test 1", "test case passed");
		GoogleSearchPageElement searchPage = new GoogleSearchPageElement(driver);
		test.info("Starting Test Case ");
		driver.get("https://google.com/");
		test.pass("Navigated to Google.com");
		searchPage.setTextinSearchBox("Slenium automation ");
		test.pass("Enter text in search box ");
		searchPage.clickOnButton();
		test.pass("submit search");

	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		extent.flush();
	}

}
