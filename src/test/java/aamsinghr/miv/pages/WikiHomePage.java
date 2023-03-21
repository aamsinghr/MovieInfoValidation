package aamsinghr.miv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aamsinghr.common.driver.WebDriverSession;

public class WikiHomePage extends WebDriverSession {

	public WikiHomePage() {
		PageFactory.initElements(getWebDriverSession(), this);
	}
	
	/**
	 * Xpath of Search combobox
	 */
	@FindBy(xpath = "//input[@name='search']")
	public WebElement searchCombobox;
	
	/**
	 * Xpath of Suggestion dropdown
	 */
	@FindBy(xpath = "//div[@class='cdx-menu cdx-menu--has-footer']")
	public WebElement movieOptions;
	
	/**
	 * Xpath of Suggestion dropdown
	 */
	@FindBy(xpath = "//div[@class='cdx-menu cdx-menu--has-footer']/ul/li/a")
	public WebElement firstMovieOption;
	
	/**
	 * Xpath of Release date
	 */
	@FindBy(xpath = "//table[@class='infobox vevent']//tr[th/div[text()='Release date']]//td/div//li")
	public WebElement releaseDate;
	
	/**
	 * Xpath of Country of origin
	 */
	@FindBy(xpath = "//table[@class='infobox vevent']//tr[th[text()='Country']]/td")
	public WebElement country;

}
