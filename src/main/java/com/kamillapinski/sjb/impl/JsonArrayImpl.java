package com.kamillapinski.sjb.impl;

import com.kamillapinski.sjb.api.JsonArray;
import com.kamillapinski.sjb.api.JsonValue;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.kamillapinski.sjb.impl.InParens.inParens;

public class JsonArrayImpl implements JsonArray {
	private final Collection<JsonValue> elements;

	public JsonArrayImpl(Collection<JsonValue> elements) {
		this.elements = Objects.requireNonNull(elements);
	}

	private static final JsonArray empty = new JsonArrayImpl(Set.of());
	public static JsonArray empty() {
		return empty;
	}

	@Override
	public String asString() {
		String joinedElements =
			elements.stream()
			        .map(JsonValue::asString)
			        .collect(Collectors.joining(",\n"));

		return inParens(
			'[',
			']',
			joinedElements
		);
	}

	@Override
	public String toString() {
		return asString();
	}
}
