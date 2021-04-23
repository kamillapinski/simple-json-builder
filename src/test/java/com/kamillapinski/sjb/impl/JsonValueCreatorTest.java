package com.kamillapinski.sjb.impl;

import com.kamillapinski.sjb.api.Json;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class JsonValueCreatorTest {
	@Nested
	class FromObject {
		@Test
		void onNull() {
			assertEquals(
				"null",
				JsonValueCreator.fromObject(null).asString()
			);
		}

		@Test
		void onString() {
			assertEquals(
				"\"hello\"",
				JsonValueCreator.fromObject("hello").asString()
			);
		}

		@Test
		void onNumberInt() {
			assertEquals(
				"1",
				JsonValueCreator.fromObject(1).asString()
			);
		}

		@Test
		void onNumberDouble() {
			assertEquals(
				"1.5",
				JsonValueCreator.fromObject(1.5).asString()
			);
		}

		@Test
		void onBoolean() {
			assertEquals(
				"true",
				JsonValueCreator.fromObject(true).asString()
			);
		}

		@Test
		void onJsonObject() {
			assertEquals(
				"{}",
				JsonValueCreator.fromObject(Json.object()).asString()
			);
		}

		@Test
		void onJsonArray() {
			assertEquals(
				"[]",
				JsonValueCreator.fromObject(Json.array()).asString()
			);
		}

		@Nested
		class ThrowsOnUnknown {
			final LocalDate passedObject = LocalDate.of(1, 2, 3);
			IllegalArgumentException exception = null;

			@BeforeEach
			void before() {
				try {
					JsonValueCreator.fromObject(passedObject);
				} catch (IllegalArgumentException ex) {
					exception = ex;
				}
			}

			@Test
			void throwsException() {
				assertNotNull(exception);
			}

			@Test
			void exceptionMessageContainsClassName() {
				assertTrue(exception.getMessage().contains(passedObject.getClass().getName()));
			}

			@Test
			void exceptionMessageContainsValue() {
				assertTrue(exception.getMessage().contains(passedObject.toString()));
			}
		}
	}
}
