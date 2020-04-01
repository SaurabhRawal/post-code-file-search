package com.saxo.assignment.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FlatFileReader implements Reader {

	@Override
	public Stream<String> read(Path path) throws IOException{
         return Files.lines(path);
	}

}
