package com.lena.task.fileparser.impl;

import com.lena.task.exception.IntArrayException;
import com.lena.task.fileparser.AdvancedIntParser;
import org.apache.log4j.Logger;

public class AdvancedIntParserImpl implements AdvancedIntParser {
    private static final Logger logger = Logger.getLogger(AdvancedIntParserImpl.class);
  private static final String SPLIT_CHAR = ";";

    @Override public int[] parseString(String line) throws IntArrayException {
        if ((line == null) || (line.isBlank())) {
            logger.error("Line is null or blank");
            throw new IntArrayException("Line is null or blank");
        }

        String[] splitLine = line.strip().split(SPLIT_CHAR);
        int[] possibleNumbers = new int[splitLine.length];

        for (int i = 0; i < splitLine.length; i++){
            try {
                String stripped = splitLine[i].strip();
                if (!stripped.isEmpty()) {
                    possibleNumbers[i] = Integer.parseInt(stripped);
                } else {
                    logger.error("Empty element found");
                    throw new IntArrayException("Empty element found in line");
                }
            }
            catch (NumberFormatException exception){
                logger.error("Cannot parse element to integer");
                throw new IntArrayException("Cannot parse element '" + splitLine[i] + "' to integer", exception);
            }
        }

        logger.info("Line was parsed into array");
        return possibleNumbers;
    }
}
