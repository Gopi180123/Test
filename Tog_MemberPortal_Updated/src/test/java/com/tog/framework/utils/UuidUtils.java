package com.tog.framework.utils;

import java.util.UUID;

public abstract class UuidUtils {

	public static UUID randomUUID() {
		return UUID.randomUUID();
	}

	public static boolean isValid(String text) {
		try {
			UUID.fromString(text);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
