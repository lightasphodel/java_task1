package com.lena.task.validator.impl;

import org.apache.log4j.Logger;

import com.lena.task.entity.IntArray;
import com.lena.task.validator.IntArrayValidator;

public class IntArrayValidatorImpl implements IntArrayValidator {
    private static final Logger logger = Logger.getLogger(IntArrayValidatorImpl.class);

    @Override
    public boolean isIntArrayValid(IntArray intArray) {
        if (intArray == null || intArray.length() == 0) {
            logger.error("Array validation failed: array is null");
            return false;
        }
        return true;
    }
}
