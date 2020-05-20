package utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

	public static WebDriver driver;
	

	public static void initConfiguration() {

		if (Constants.browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\jars\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			//log.debug("Launching firefox");
		} else if (Constants.browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\jars\\selenium\\chromedriver.exe");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
			//log.debug("Chrome Launched !!!");
		}

		//driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.implicitwait, TimeUnit.SECONDS);
		//wait = new WebDriverWait();

	}
}
