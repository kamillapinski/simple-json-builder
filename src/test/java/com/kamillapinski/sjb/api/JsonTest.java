package com.kamillapinski.sjb.api;

import com.kamillapinski.sjb.ClasspathLoader;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.kamillapinski.sjb.api.Json.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonTest {
	private static String expected(String name) {
		return ClasspathLoader.loadJson(Paths.get("expected", name));
	}

	@Nested
	class Empty {
		@Test
		void emptyObject() {
			assertEquals("{}", object().asString());
		}

		@Test
		void emptyArray() {
			assertEquals("[]", array().asString());
		}
	}

	@Nested
	class OneElement {
		@Test
		void oneFieldObject() {
			String expectedString = expected("one-field.json");
			String resultString = object(
				field("field", "value")
			).asString();

			assertEquals(expectedString, resultString);
		}

		@Test
		void oneElementArray() {
			String expectedString = expected("one-element.json");
			String resultString = array("hello").asString();

			assertEquals(expectedString, resultString);
		}
	}

	@Nested
	class TwoElements {
		@Test
		void twoFieldsObject() {
			String expectedString = expected("two-fields.json");
			String resultString = object(
				field("first", 1),
				field("second", true)
			).asString();

			assertEquals(expectedString, resultString);
		}

		@Test
		void twoElementsArray() {
			String expectedString = expected("two-elements.json");
			String resultString = array(
				1,
				"two"
			).asString();

			assertEquals(expectedString, resultString);
		}
	}

	@Nested
	class NestedValues {
		@Test
		void nestedObject() {
			String expectedString = expected("nested-object.json");
			String resultString = object(
				field("field", "value"),
				field("nested", object(
					field("a", 1),
					field("b", "two"),
					field("c", false),
					field("d", object()),
					field("e", array(
						"a",
						"b",
						"c"
					))
				))
			).asString();

			assertEquals(expectedString, resultString);
		}

		@Test
		void nestedArray() {
			String expectedString = expected("nested-array.json");
			String resultString = array(
				1,
				object(
					field("a", "b"),
					field("c", "d")
				)
			).asString();

			assertEquals(expectedString, resultString);
		}
	}

	@Nested
	class Null {
		@Test
		void objectNull() {
			String expectedString = expected("object-null.json");
			String resultString = object(
				nullField("field")
			).asString();

			assertEquals(expectedString, resultString);
		}

		@Test
		void arrayNull() {
			String expectedString = expected("array-null.json");
			String resultString = array(null, true).asString();

			assertEquals(expectedString, resultString);
		}
	}

	@Nested
	class ToStringEqualsAsString {
		@Test
		void objectToString() {
			JsonObject jsonObject = object(
				field("a", "b"),
				field("b", object(
					field("c", "d"),
					field("e", array(
						1,
						"hello",
						true,
						2,
						object(
							field("r", "4")
						)
					))
				)),
				nullField("y")
			);

			assertEquals(
				jsonObject.asString(),
				jsonObject.toString()
			);
		}

		@Test
		void arrayToString() {
			JsonArray jsonArray = array(
				1,
				true,
				null,
				"hello",
				object(
					field("a", "b"),
					field("b", array())
				)
			);

			assertEquals(
				jsonArray.asString(),
				jsonArray.toString()
			);
		}
	}
}
