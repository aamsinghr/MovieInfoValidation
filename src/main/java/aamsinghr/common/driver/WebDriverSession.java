package aamsinghr.common.driver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSession {

	protected static WebDriver webDriver = null;
	public static Map<Long, WebDriver> map = new HashMap<>();


	public static WebDriver getWebDriverForCurrentThread() {
		return map.get(Thread.currentThread().getId());
	}

	/**
	 * OBJECTIVE: Get the Webdriver instance so It can be reused during the script.
	 */
	public static WebDriver getWebDriverSession() {
		WebDriver toReturn = map.get(Thread.currentThread().getId());
		if (toReturn == null) {
			loadNewWebDriverSession();
			toReturn = map.get(Thread.currentThread().getId());
		}
		return toReturn;
	}

	/**
	 * OBJECTIVE: Load a NEW session of driver when there is not an existing to work on.
	 */
	public static void loadNewWebDriverSession() {
		WebDriver webDriver = null;
		try {

			WebDriverManager webDriverManager = WebDriverManager.chromedriver();
			ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
			webDriverManager.setup();
			webDriver = new ChromeDriver(options);                      
		}catch (RuntimeException e) {
		}

		if (webDriver == null) {
			throw new UnsupportedOperationException("webDriver is null");
		} else {
			webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			webDriver.manage().window().maximize();
			webDriver.manage().deleteAllCookies();
			// Save driver session
			map.put(Thread.currentThread().getId(), webDriver);
		}
	}

}
