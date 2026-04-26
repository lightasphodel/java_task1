package com.lena.task.sort.impl;

import com.lena.task.sort.IntArraySort;
import com.lena.task.entity.IntArray;
import com.lena.task.exception.IntArrayException;

public class IntArraySortImpl implements IntArraySort {
    @Override public void insertSort(IntArray intArray) throws IntArrayException{
        int[] unsortedArray = intArray.getArray(); /*will be useful to see the config before sort */
        for (int i = 1; i < intArray.length(); i++) {
            int key = intArray.getElement(i);
            int j = i - 1;
            while (j >= 0 && intArray.getElement(j) > key) {
                int value = intArray.getElement(j);
                intArray.setElement(j + 1, value);
                j--;
            }
            intArray.setElement(j + 1, key);
        }
    }

    @Override public void bubbleSort(IntArray intArray) throws IntArrayException{
        for (int i = 0; i < (intArray.length() - 1); i++) {
            for(int j = 0; j < (intArray.length() - i - 1); j++) {
                if (intArray.getElement(j) > intArray.getElement(j + 1)) {
                    int valueJ = intArray.getElement(j);
                    int valueJ1 = intArray.getElement(j + 1);
                    intArray.setElement(j, valueJ1);
                    intArray.setElement(j + 1, valueJ);
                }
            }
        }
    }
}
