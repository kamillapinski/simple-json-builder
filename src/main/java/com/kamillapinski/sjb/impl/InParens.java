package com.kamillapinski.sjb.impl;

import java.util.Objects;

import static com.kamillapinski.sjb.impl.Indent.indented;

public class InParens {
	private InParens() {}

	public static String inParens(char opening, char closing, String value) {
		Objects.requireNonNull(value);

		if (value.isEmpty()) {
			return String.valueOf(opening) + closing;
		} else {
			return opening + "\n" + indented(value) + "\n" + closing;
		}
	}
}
