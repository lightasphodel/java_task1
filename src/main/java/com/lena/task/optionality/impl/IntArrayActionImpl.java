package com.lena.task.optionality.impl;

import com.lena.task.entity.IntArray;
import com.lena.task.optionality.IntArrayAction;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;

public class IntArrayActionImpl implements IntArrayAction{
    private static final Logger logger = Logger.getLogger(IntArrayActionImpl.class);

    @Override public OptionalInt min(IntArray intArray) {
        OptionalInt min = IntStream.of(intArray.getArray()).min();
        logger.info("Min function has been called");
        return min;
    }
    
    @Override public OptionalInt max(IntArray intArray) {
        OptionalInt max = IntStream.of(intArray.getArray()).max();
        logger.info("Max function has been called");
        return max;
    }

    @Override public OptionalInt sum(IntArray intArray) {
        int sum = IntStream.of(intArray.getArray()).sum();
        logger.info("Sum function has been called");
        return OptionalInt.of(sum);
    }

    @Override public OptionalDouble average(IntArray intArray) {
        OptionalDouble average = IntStream.of(intArray.getArray()).average();
        logger.info("Average function has been called");
        return average;
    }
}
