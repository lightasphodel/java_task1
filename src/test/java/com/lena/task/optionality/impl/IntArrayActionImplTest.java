package com.lena.task.optionality.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lena.task.entity.IntArray;
import com.lena.task.exception.IntArrayException;
import com.lena.task.repository.IntArrayRepository;

class IntArrayActionImplTest {
    private IntArrayRepository repository;
    private IntArray array1;
    private IntArray array2;
    private IntArray array3;

    @BeforeEach
    void setUp() throws IntArrayException {
        repository = IntArrayRepository.getInstance();

        array1 = new IntArray(new int[]{1, 2, 3});
        array2 = new IntArray(new int[]{4, 5, 6, 7, 8});
        array3 = new IntArray(new int[]{9, 10});
    }

    @Test
    void addTest() {
        repository.add(array1);
        repository.add(array2);
        repository.add(array3);
    }

    @Test
    void getTest() {
        repository.add(array1);
        repository.add(array2);
        repository.add(array3);
        List<IntArray> arrays = repository.getIntArrays();
        assertEquals(3, arrays.size());
        assertTrue(arrays.contains(array1));
        assertTrue(arrays.contains(array2));
        assertTrue(arrays.contains(array3));
    }
}
