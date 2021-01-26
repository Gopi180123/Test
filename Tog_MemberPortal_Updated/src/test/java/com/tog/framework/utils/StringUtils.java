package com.tog.framework.utils;

import org.apache.commons.lang3.RandomStringUtils;

public abstract class StringUtils {

	public static String randomString() {
		return ("Test_" + RandomStringUtils.randomAlphabetic(4));
	}

}
