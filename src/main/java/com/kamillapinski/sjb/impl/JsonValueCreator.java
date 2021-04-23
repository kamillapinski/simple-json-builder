package com.kamillapinski.sjb.impl;

import com.kamillapinski.sjb.api.JsonArray;
import com.kamillapinski.sjb.api.JsonObject;
import com.kamillapinski.sjb.api.JsonValue;

public class JsonValueCreator {
	private JsonValueCreator() {
	}

	public static JsonValue fromObject(Object object) {
		if (object == null) {
			return JsonRawValue.nullValue();
		}

		if (object instanceof String) {
			return new JsonStringValue(object.toString());
		} else if (object instanceof Number) {
			return new JsonRawValue(object.toString());
		} else if (object instanceof Boolean) {
			return new JsonRawValue(object.toString());
		} else if (object instanceof JsonObject || object instanceof JsonArray) {
			var value = (JsonValue) object;
			return new JsonRawValue(value.asString());
		} else {
			throw new IllegalArgumentException("Unknown object type: " + object.getClass() + "\nfor object " + object);
		}
	}
}
