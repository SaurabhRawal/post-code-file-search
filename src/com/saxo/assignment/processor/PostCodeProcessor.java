package com.saxo.assignment.processor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.saxo.assignment.reader.Reader;

public class PostCodeProcessor implements Processor {

	private static final String POST_CODE_REGEX_FOR_NETHERLAND = "(.*?)(NL-)?(\\d{4})\\s*([A-Z]{2})?\\s+(.*?)";

	public List<String> process(Reader reader, Path path, String outputFileName) {
		List<String> listOfLines = new ArrayList<>();
		try (Stream<String> stream = reader.read(path)) {
			listOfLines = stream.filter(line -> line.matches(POST_CODE_REGEX_FOR_NETHERLAND))
					      //.peek(System.out::println)
					      .collect(Collectors.toList());
			listOfLines.forEach(line -> writeToFile(line, path, outputFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfLines;
	}

	private void writeToFile(String line, Path path, String outputFileName) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFileName), StandardOpenOption.CREATE,
				StandardOpenOption.APPEND)) {
			writer.append(String.join(" : ", path.toString(), line));
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
