package com.dollardays.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {

	public static Properties props = null;
	public static FileInputStream fileInputStream = null;

	public void readPropertyData() throws Exception {

		props = new Properties();

		try {

			fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\application.proerties");
			props.load(fileInputStream);
			 System.out.println("---->"+props.getProperty("driver"));

		} catch (Exception e) {
			throw new Exception("Property file is not found");
		}

	}

	public static String getProperty(String value) throws Exception {
		String propValue;
		try {
			
			 propValue = props.getProperty(value);
			 System.out.println("---->"+propValue);
			
		} catch (Exception e) {
			throw new Exception("Key not found");
		}
		return propValue;
	}

}
