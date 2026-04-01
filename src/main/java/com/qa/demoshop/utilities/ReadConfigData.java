package com.qa.demoshop.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {
	public Properties prop;

	public ReadConfigData() throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Config.properties");
		prop = new Properties();
		prop.load(fis);
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
