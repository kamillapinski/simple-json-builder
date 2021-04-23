package com.kamillapinski.sjb.impl;

import com.kamillapinski.sjb.api.JsonValue;

public class JsonRawValue implements JsonValue {
	private final Object value;

	public JsonRawValue(Object value) {
		this.value = value;
	}

	@Override
	public String asString() {
		return value.toString();
	}

	private static final JsonRawValue nullValue = new JsonRawValue("null");
	public static JsonRawValue nullValue() {
		return nullValue;
	}

	@Override
	public String toString() {
		return asString();
	}
}
