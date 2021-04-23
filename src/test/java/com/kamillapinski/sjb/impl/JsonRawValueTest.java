package com.kamillapinski.sjb.impl;

import com.kamillapinski.sjb.api.JsonValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonRawValueTest {
	@Test
	void returnsRawValue() {
		String input = "hello\n world\\sdf\"";
		JsonValue value = new JsonRawValue(input);

		assertEquals(
			input,
			value.asString()
		);
	}

	@Test
	void toStringEqualsAsString() {
		JsonValue value = new JsonRawValue("rgwioejlfnbqweuilfhoejnrbweuif");

		assertEquals(value.asString(), value.toString());
	}
}
