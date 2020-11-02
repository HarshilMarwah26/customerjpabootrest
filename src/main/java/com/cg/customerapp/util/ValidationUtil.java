package com.cg.customerapp.util;

import com.cg.customerapp.exception.*;

public class ValidationUtil {

	public static void checkArgumentNotNull(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("arg can't be null");
		}
	}

	public static void checkName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidNameException("name is not valid");
		}

	}

}
