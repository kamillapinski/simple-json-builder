package com.kamillapinski.sjb.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.kamillapinski.sjb.impl.Escape.escape;
import static org.junit.jupiter.api.Assertions.*;

class EscapeTest {
	@Nested
	class escape {
		@Test
		void newLine() {
			String stringWithNewlines = "a\nbc\n";
			String expected = "a\\nbc\\n";
			String escaped = escape(stringWithNewlines);

			assertEquals(expected, escaped);
		}

		@Test
		void backslash() {
			String stringWithBackslash = "a\\bc\\";
			String expected = "a\\\\bc\\\\";
			String escaped = escape(stringWithBackslash);

			assertEquals(expected, escaped);
		}

		@Test
		void quote() {
			String stringWithQuote = "a\"bc\"";
			String expected = "a\\\"bc\\\"";
			String escaped = escape(stringWithQuote);

			assertEquals(expected, escaped);
		}

		@Test
		void tab() {
			String stringWithTab = "a\tbc\t";
			String expected = "a\\tbc\\t";
			String escaped = escape(stringWithTab);

			assertEquals(expected, escaped);
		}

		@Test
		void all() {
			String dirtyString = "a\"b\nc\\d\te";
			String escaped = escape(dirtyString);
			String expected = "a\\\"b\\nc\\\\d\\te";

			assertEquals(expected, escaped);
		}
	}
}
