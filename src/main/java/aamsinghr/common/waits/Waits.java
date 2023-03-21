package aamsinghr.common.waits;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aamsinghr.common.driver.WebDriverSession;

public class Waits {
	
	public static void waitForElementVisibility(WebElement element, int seconds) {
        
        WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
