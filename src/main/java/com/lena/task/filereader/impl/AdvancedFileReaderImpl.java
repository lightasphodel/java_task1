package com.lena.task.filereader.impl;

import com.lena.task.exception.IntArrayException;
import com.lena.task.filereader.AdvancedFileReader;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AdvancedFileReaderImpl implements AdvancedFileReader{
    private static final Logger logger = Logger.getLogger(AdvancedFileReaderImpl.class);
    private static final String DEFAULT_FILE_PATH = "data/input.txt";

    @Override public List<String> readFile(String filePath) throws IntArrayException {
        if ((filePath == null) || (filePath.isBlank())) {
            logger.error("File path is null or empty");
            throw new IntArrayException("File path is null or empty");
        }
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            logger.warn("File not found. Using default path");
            filePath = DEFAULT_FILE_PATH;
            path = Paths.get(filePath);
        }
        try {
            List<String> result = Files.readAllLines(path);
            logger.info("Successfully read lines from file. Amount" + result.size());
            return result;
        } catch (IOException exception) {
            logger.error("Cannot read the file " + exception.getMessage());
            throw new IntArrayException("Cannot read the file");
        }
    }
}
