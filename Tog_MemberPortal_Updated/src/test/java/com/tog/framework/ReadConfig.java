 package com.tog.framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	String url = "";

	public ReadConfig() {
		File src = new File("./configuration/config.properties");
		try {
			pro = new Properties();
			pro.load(new FileInputStream(src));
		} catch (Exception e) {
			System.err.println("Exception while loading properties " + e.getMessage());
		}
	}

	public String getBasrUrl() {
		return pro.getProperty("baseurl");
	}

	public String getFunctionKey() {
		return pro.getProperty("functionkey");
	}
	
	public String getSearchBaseUrl() {
		return pro.getProperty("searchbaseurl");
	}
	public String getSearchFunctionKey() {
		return pro.getProperty("searchfunctionkey");
	}
}
