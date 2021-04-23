package com.kamillapinski.sjb.impl;

import com.kamillapinski.sjb.api.JsonField;
import com.kamillapinski.sjb.api.JsonObject;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.kamillapinski.sjb.impl.InParens.inParens;

public class JsonObjectImpl implements JsonObject {
	private final Collection<JsonField> fields;

	private static JsonObject empty = new JsonObjectImpl(Set.of());
	public static JsonObject empty() {
		return empty;
	}

	public JsonObjectImpl(Collection<JsonField> fields) {
		this.fields = Objects.requireNonNull(fields);
	}

	@Override
	public String asString() {
		String joinedFields =
			fields.stream()
			      .map(JsonField::asString)
			      .collect(Collectors.joining(",\n"));

		return inParens(
			'{',
			'}',
			joinedFields
		);
	}

	@Override
	public String toString() {
		return asString();
	}
}
