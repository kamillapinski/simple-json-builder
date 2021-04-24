package com.kamillapinski.sjb.impl;

public class NullHelper {
	private NullHelper() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] arrayIfNull(T[] array) {
		if (array == null) {
			return (T[]) new Object[] {null};
		} else {
			return array;
		}
	}
}
