package com.lena.task.factory;

import com.lena.task.entity.IntArray;
import com.lena.task.exception.IntArrayException;

public interface IntArrayFactory {
    IntArray createIntArray(int[] array) throws IntArrayException;
}
