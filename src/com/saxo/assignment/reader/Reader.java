package com.saxo.assignment.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Reader {

	/**
	 * @param path
	 * @return
	 * @throws IOException
	 */
	Stream<String> read(Path path) throws IOException;

	/**
	 * @param directoryPath
	 * @return
	 */
	default List<Path> getfilePaths(String directoryPath) {
		List<Path> path = new ArrayList<>();
		try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {			
			path = paths.filter(Files::isRegularFile).collect(Collectors.toList());			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
