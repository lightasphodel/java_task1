package com.lena.task.factory.impl;

import com.lena.task.entity.IntArray;
import com.lena.task.exception.IntArrayException;
import com.lena.task.factory.IntArrayFactory;
import org.apache.log4j.Logger;

public class IntArrayFactoryImpl implements IntArrayFactory {
    private static final Logger logger = Logger.getLogger(IntArrayFactoryImpl.class);

    @Override public IntArray createIntArray(int[] array) throws IntArrayException {
        if ((array == null) || (array.length == 0)) {
        logger.error("Factory get invalid array");
        throw new IntArrayException("Factory get invalid array");
        }
        return new IntArray(array);
    }
}
