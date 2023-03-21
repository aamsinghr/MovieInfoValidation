package aamsinghr.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

//import com.aventstack.extentreports.Status;
import com.google.common.io.Resources;

public class SystemProperties {

	/** The prop. */
	private static Properties prop;

	public static final String MOVIE_NAME = getProp().getProperty("movie.name");

	public static final String IMDB_URL = getProp().getProperty("imdb.url");

	public static final String WIKI_URL = getProp().getProperty("wiki.url");

	private SystemProperties() {
		throw new IllegalStateException("Utility class");
	}

	private static Properties getProp() 
	{
		if (prop == null) 
		{
			prop = new Properties();
			InputStream input = null;

			try {
				input = new FileInputStream(new File(Resources.getResource("system.properties").toURI()));
				prop.load(input);
			} catch (URISyntaxException |IOException e) {
			} 
		}

		return prop;
	}

}
