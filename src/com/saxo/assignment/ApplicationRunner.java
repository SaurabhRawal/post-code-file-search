package com.saxo.assignment;

import java.nio.file.Path;
import java.util.List;

import com.saxo.assignment.processor.PostCodeProcessor;
import com.saxo.assignment.reader.FlatFileReader;
import com.saxo.assignment.reader.Reader;

public class ApplicationRunner {
	
	private static final String FILE_SYSTEM_DIRECTORY_PATH = "C:\\Users\\saurabhrawal\\Test";
	private static final String OUTPUT_FILE_PATH = "C:\\Users\\saurabhrawal\\Testoutput\\SaxoPostalCode2.txt";
	
	public static void main(String[] args) {		
		 PostCodeProcessor postCodeProcessor = new PostCodeProcessor();
		 Reader flatFileReader = new FlatFileReader();
		 List<Path> paths = flatFileReader.getfilePaths(FILE_SYSTEM_DIRECTORY_PATH);
		 paths.stream().forEach(path -> postCodeProcessor.process(flatFileReader, path, OUTPUT_FILE_PATH));	 		 
	}

}
