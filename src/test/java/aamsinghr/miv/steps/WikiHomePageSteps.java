package aamsinghr.miv.steps;

import aamsinghr.common.waits.Waits;
import aamsinghr.miv.pages.WikiHomePage;

public class WikiHomePageSteps {
	
	/**
	 * Enter Input text - Movie Name in combobox
	 */
	public static void enterMovieName(String movieName) {
		WikiHomePage wikiHomePage = new WikiHomePage();
		wikiHomePage.searchCombobox.clear();;
		wikiHomePage.searchCombobox.sendKeys(movieName);
	}
	
	/**
	 * Select - first Movie from the dropdown
	 */
	public static void selectMovie() {
		WikiHomePage wikiHomePage = new WikiHomePage();
		Waits.waitForElementVisibility(wikiHomePage.movieOptions, 30);
		wikiHomePage.firstMovieOption.click();
		Waits.waitForElementVisibility(wikiHomePage.releaseDate, 30);
	}
	
	/**
	 * Get - Movie release date
	 */
	public static String getMovieReleaseDate() {
		WikiHomePage wikiHomePage = new WikiHomePage();
		return wikiHomePage.releaseDate.getText();
	}
	
	/**
	 * Get - Movie Country
	 */
	public static String getMovieCountry() {
		WikiHomePage wikiHomePage = new WikiHomePage();
		return wikiHomePage.country.getText();
	}

}
