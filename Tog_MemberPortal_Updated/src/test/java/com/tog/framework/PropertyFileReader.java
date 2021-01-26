package com.tog.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	Properties props;

	public PropertyFileReader(String filepath) throws IOException {
		props = new Properties();
		props.load(new FileInputStream(new File(filepath)));
	}

	public String get(String key) {
		return props.getProperty(key);
	}
}