package com.kamillapinski.sjb.api;

import com.kamillapinski.sjb.impl.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kamillapinski.sjb.impl.NullHelper.arrayIfNull;

/**
 * The only class you will ever need to use Simple Json Builder. Import static methods from this class to make use of SJB.
 *
 * Example:
 * <pre>
 *
 * object(
 *     field("hello", "world"),
 *     field("array", array(1, 2, 3, 4))
 * ).asString();
 * </pre>
 */
public class Json {
	private Json() {
	}

	public static JsonObject object(JsonField... fields) {
		Objects.requireNonNull(fields);

		if (fields.length == 0) {
			return JsonObjectImpl.empty();
		}

		return new JsonObjectImpl(List.of(fields));
	}

	public static JsonArray array() {
		return JsonArrayImpl.empty();
	}

	public static JsonArray array(Object... values) {
		var elements
			= Stream.of(arrayIfNull(values))
			        .map(JsonValueCreator::fromObject)
			        .collect(Collectors.toList());

		return new JsonArrayImpl(elements);
	}

	public static JsonField field(String name, String value) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(value);

		return new JsonFieldImpl(name, new JsonStringValue(value));
	}

	public static JsonField field(String name, Number value) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(value);

		return new JsonFieldImpl(name, new JsonRawValue(value.toString()));
	}

	public static JsonField field(String name, JsonArray value) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(value);

		return new JsonFieldImpl(name, new JsonRawValue(value.asString()));
	}

	public static JsonField field(String name, boolean value) {
		Objects.requireNonNull(name);

		return new JsonFieldImpl(name, new JsonRawValue(Boolean.toString(value)));
	}

	public static JsonField field(String name, JsonObject value) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(value);

		return new JsonFieldImpl(name, new JsonRawValue(value.asString()));
	}

	public static JsonField nullField(String name) {
		Objects.requireNonNull(name);

		return new JsonFieldImpl(name, JsonRawValue.nullValue());
	}
}
