package com.kamillapinski.sjb.impl;

import com.kamillapinski.sjb.api.JsonField;
import com.kamillapinski.sjb.api.JsonValue;

import java.util.Objects;

public class JsonFieldImpl implements JsonField {
	private final String name;
	private final JsonValue value;

	public JsonFieldImpl(String name, JsonValue value) {
		this.name = Objects.requireNonNull(name);
		this.value = Objects.requireNonNull(value);
	}

	@Override
	public String asString() {
		String field = new JsonStringValue(name).asString();
		String fieldValue = value.asString();

		return field + ": " + fieldValue;
	}
}
