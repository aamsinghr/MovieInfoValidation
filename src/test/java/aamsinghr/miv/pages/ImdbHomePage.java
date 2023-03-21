package aamsinghr.miv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aamsinghr.common.driver.WebDriverSession;

public class ImdbHomePage extends WebDriverSession {

	public ImdbHomePage() {
		PageFactory.initElements(getWebDriverSession(), this);
	}
	
	/**
	 * Xpath of Search combobox
	 */
	@FindBy(xpath = "//input[@id='suggestion-search']")
	public WebElement searchCombobox;
	
	/**
	 * Xpath of Suggestion dropdown
	 */
	@FindBy(xpath = "//div[@id='imdbHeader__search-menu']")
	public WebElement movieOptions;
	
	/**
	 * Xpath of Suggestion dropdown
	 */
	@FindBy(xpath = "//div[@id='imdbHeader__search-menu']//ul[@role='listbox']/li[@role='option']/a")
	public WebElement firstMovieOption;
	
	/**
	 * Xpath of Release date
	 */
	@FindBy(xpath = "//div[@data-testid='title-details-section']/ul/li[a[text()='Release date']]//div//a")
	public WebElement releaseDate;
	
	/**
	 * Xpath of Country of origin
	 */
	@FindBy(xpath = "//div[@data-testid='title-details-section']/ul/li[span[text()='Country of origin']]//div//a")
	public WebElement country;

}
