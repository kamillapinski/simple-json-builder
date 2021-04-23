package com.kamillapinski.sjb.impl;

import com.kamillapinski.sjb.api.JsonValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonStringValueTest {
	@Test
	void wrapsInQuotes() {
		String input = "hello world";
		JsonValue value = new JsonStringValue(input);

		String expected = "\"" + input + "\"";

		assertEquals(expected, value.asString());
	}

	@Test
	void escapes() {
		String input = "a\"bcd\ng";
		JsonValue value = new JsonStringValue(input);

		String expected = "\"a\\\"bcd\\ng\"";

		assertEquals(expected, value.asString());
	}

	@Test
	void toStringEqualsAsString() {
		JsonValue value = new JsonStringValue("guw;ofijnweifowerhq2389ef\"wefhwidf");

		assertEquals(value.asString(), value.toString());
	}
}
