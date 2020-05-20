package steps;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.TestBase;

public class Hooks {

	@Before
	public void setUp() {
		System.out.println("Running----------------------- Before");
		TestBase.initConfiguration();
	}

	@After(order=1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			System.out.println("Running----------------------- After");
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				byte[] screenshotBytes = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
				//File sourcePath = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
				File sourcePath = OutputType.FILE.convertFromPngBytes(screenshotBytes);
				File destinationPath = new File(
						System.getProperty("user.dir") + "\\target\\extentreport\\" + screenshotName + ".png");

				// Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);

				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				scenario.embed(screenshotBytes, "image/png");
			} catch (IOException e) {
			}
		}

	}
	
	@After(order=0)
	public void tearDown() {
		System.out.println("Quiting the browser");
		if(TestBase.driver!=null) {
			TestBase.driver.quit();
		}
	}

}
