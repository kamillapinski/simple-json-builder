package com.kamillapinski.sjb.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class NullHelperTest {

	@Nested
	class arrayIfNull {
		@Test
		void returnSameArrayIfNotNull() {
			Object[] array = new Object[] {1, 2, 3, 4};

			assertSame(
				array,
				NullHelper.arrayIfNull(array)
			);
		}

		@Test
		void returnArrayWithNull() {
			assertArrayEquals(
				new Object[] {null},
				NullHelper.arrayIfNull(null)
			);
		}
	}
}
