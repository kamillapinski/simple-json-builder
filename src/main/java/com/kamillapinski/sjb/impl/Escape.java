package com.kamillapinski.sjb.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static java.util.Map.entry;

class Escape {
	private Escape() {
	}

	private static final List<Map.Entry<String, String>> ESCAPES = List.of(
		entry("\\", "\\\\"),
		entry("\"", "\\\""),
		entry("\n", "\\n"),
		entry("\t", "\\t")
	);

	public static String escape(String unescaped) {
		Objects.requireNonNull(unescaped);

		return ESCAPES.stream()
		              .map(entry -> (Function<String, String>) prev -> prev.replace(entry.getKey(), entry.getValue()))
		              .reduce(Function.identity(), Function::andThen)
		              .apply(unescaped);
	}
}
