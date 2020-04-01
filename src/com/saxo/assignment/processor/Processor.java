package com.saxo.assignment.processor;

import java.nio.file.Path;
import java.util.List;

import com.saxo.assignment.reader.Reader;

public interface Processor {
	
	List<String> process(Reader reader, Path path, String outputFileName);

}
