package aamsinghr.miv.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import aamsinghr.common.driver.WebDriverSession;
import aamsinghr.common.utils.DateUtils;
import aamsinghr.common.utils.SystemProperties;
import aamsinghr.miv.steps.ImdbHomePageSteps;
import aamsinghr.miv.steps.WikiHomePageSteps;

public class MovieInfoValidationTest {
	
	@AfterMethod
	public void closeBrowser() {
		WebDriverSession.getWebDriverSession().close();
	}
	
	@Test
	public void validateCountryAndReleaseDate() {
		WebDriverSession.getWebDriverSession().get(SystemProperties.IMDB_URL);
		ImdbHomePageSteps.enterMovieName(SystemProperties.MOVIE_NAME);
		ImdbHomePageSteps.selectMovie();
		String imdbDate=ImdbHomePageSteps.getMovieReleaseDate();
		String imdbCountry=ImdbHomePageSteps.getMovieCountry();
		
		WebDriverSession.getWebDriverSession().get(SystemProperties.WIKI_URL);
		WikiHomePageSteps.enterMovieName(SystemProperties.MOVIE_NAME);
		WikiHomePageSteps.selectMovie();
		String wikiDate=WikiHomePageSteps.getMovieReleaseDate();
		String wikiCountry=WikiHomePageSteps.getMovieCountry();
		
		Assert.assertEquals(imdbCountry, wikiCountry);
		Assert.assertEquals(DateUtils.convertStringToDate(imdbDate, DateUtils.FORMAT_MMMMM_dd_yyyy),
				DateUtils.convertStringToDate(wikiDate, DateUtils.FORMAT_dd_MMMMM_yyyy));
		
	}

}
