package com.lena.task;

import java.util.List;

import org.apache.log4j.Logger;

import com.lena.task.comparator.IntArrayComparator;
import com.lena.task.entity.IntArray;
import com.lena.task.exception.IntArrayException;
import com.lena.task.factory.IntArrayFactory;
import com.lena.task.factory.impl.IntArrayFactoryImpl;
import com.lena.task.fileparser.AdvancedIntParser;
import com.lena.task.fileparser.impl.AdvancedIntParserImpl;
import com.lena.task.filereader.AdvancedFileReader;
import com.lena.task.filereader.impl.AdvancedFileReaderImpl;
import com.lena.task.repository.IntArrayRepository;
import com.lena.task.repository.impl.AvgBetweenSpecification;
import com.lena.task.validator.IntArrayValidator;
import com.lena.task.validator.impl.IntArrayValidatorImpl;


public class App {
    private static final Logger logger = Logger.getLogger(App.class);
    private static final String FILE_PATH = "data/input.txt";

    public static void main(String[] args){
        logger.info("The program has been successfully started");

        try {
            AdvancedFileReader fileReader = new AdvancedFileReaderImpl();
            AdvancedIntParser parser = new AdvancedIntParserImpl();
            IntArrayFactory factory = new IntArrayFactoryImpl();
            IntArrayRepository repository = IntArrayRepository.getInstance();
            IntArrayValidator validator = new IntArrayValidatorImpl();


            List<String> readLines = fileReader.readFile(FILE_PATH);
            logger.info("File has been successfully read");

            if (readLines.isEmpty()) {
                logger.warn("File is empty");
                return;
            }

            for (int i = 0; i < readLines.size(); i++) {
                String line = readLines.get(i);
                logger.info("Processing line " + line);

                try {
                    int[] numbers = parser.parseString(line);
                    
                    IntArray intArray = factory.createIntArray(numbers);
                    validator.isIntArrayValid(intArray);
                    repository.add(intArray);

                    repository.sort(IntArrayComparator.BY_ID);
                    logger.info("Sorted by ID");

                    repository.sort(IntArrayComparator.BY_ELEMENTS_AMOUNT);
                    logger.info("Sorted by length");

                    repository.query(new AvgBetweenSpecification(0, 10));
                    logger.info("Arrays with avg between 0-10");

                } catch (IntArrayException e) {
                    logger.error("Error processing line", e);
                }
            }
        } catch (IntArrayException e) {
            logger.fatal("Fatal error: " + e.getMessage());
        }

        logger.info("Program has been finished");
    }
}
