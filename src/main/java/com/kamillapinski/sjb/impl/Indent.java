package com.kamillapinski.sjb.impl;

class Indent {
	private Indent() {}

	public static String indented(String value) {
		return "\t" + value.replace("\n", "\n\t");
	}
}
