package aamsinghr.miv.steps;

import aamsinghr.common.waits.Waits;
import aamsinghr.miv.pages.ImdbHomePage;

public class ImdbHomePageSteps {
	
	/**
	 * Enter Input text - Movie Name in combobox
	 */
	public static void enterMovieName(String movieName) {
		ImdbHomePage imdbHomePage = new ImdbHomePage();
		imdbHomePage.searchCombobox.clear();;
		imdbHomePage.searchCombobox.sendKeys(movieName);
	}
	
	/**
	 * Select - first Movie from the dropdown
	 */
	public static void selectMovie() {
		ImdbHomePage imdbHomePage = new ImdbHomePage();
		Waits.waitForElementVisibility(imdbHomePage.movieOptions, 30);
		Waits.gerericWait(1000);
		imdbHomePage.firstMovieOption.click();
		Waits.waitForElementVisibility(imdbHomePage.releaseDate, 30);
	}
	
	/**
	 * Get - Movie release date
	 */
	public static String getMovieReleaseDate() {
		ImdbHomePage imdbHomePage = new ImdbHomePage();
		return imdbHomePage.releaseDate.getText();
	}
	
	/**
	 * Get - Movie Country
	 */
	public static String getMovieCountry() {
		ImdbHomePage imdbHomePage = new ImdbHomePage();
		return imdbHomePage.country.getText();
	}

}
