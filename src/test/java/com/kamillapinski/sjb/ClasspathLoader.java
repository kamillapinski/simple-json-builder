package com.kamillapinski.sjb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClasspathLoader {
	public static String loadJson(Path path) {
		var inputStream = ClasspathLoader.class.getClassLoader().getResourceAsStream(path.toString());
		Objects.requireNonNull(inputStream);

		return new BufferedReader(new InputStreamReader(inputStream))
			       .lines()
			       .filter(line -> !line.isEmpty())
			       .collect(Collectors.joining("\n"));
	}
}
