package com.lena.task.sort;

import com.lena.task.entity.IntArray;
import com.lena.task.exception.IntArrayException;

public interface IntArraySort {
    public void insertSort(IntArray intArray) throws IntArrayException;
    public void bubbleSort(IntArray intArray) throws IntArrayException;
}
