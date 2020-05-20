package runner;

import java.io.File;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "json:target/cucumber.json", "pretty", "html:target/cucumber-reports",
		"com.cucumber.listener.ExtentCucumberFormatter:target/extentreport/report.html" }, 
		features = "src/test/resources/features", glue = "steps", 
		//tags = {"@Search-Cars" },
		monochrome = true)
public class RunCuke extends AbstractTestNGCucumberTests {
	
	@BeforeSuite
	    public static void setup() {
		System.out.println("Running----------------------- Before Suite");
	}

	@AfterSuite
	public static void writeExtentReport() {
		System.out.println("Running----------------------------After Suite");
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));

	}

}
