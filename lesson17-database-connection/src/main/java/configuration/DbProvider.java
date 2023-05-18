package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DbProvider {
	// find path
	private static String path = "db-config.properties";

	public static Properties getDbProps() {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File(path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
}
