package com.kamillapinski.sjb.impl;

import com.kamillapinski.sjb.api.JsonValue;

import static com.kamillapinski.sjb.impl.Escape.escape;

public class JsonStringValue implements JsonValue {
	private final String value;

	public JsonStringValue(String value) {
		this.value = value;
	}

	@Override
	public String asString() {
		return "\"" + escape(value) + "\"";
	}

	@Override
	public String toString() {
		return asString();
	}
}
