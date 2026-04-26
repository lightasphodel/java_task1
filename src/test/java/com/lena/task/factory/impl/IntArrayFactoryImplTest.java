package com.lena.task.factory.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lena.task.entity.IntArray;
import com.lena.task.exception.IntArrayException;

public class IntArrayFactoryImplTest {
    private IntArrayFactoryImpl factory;

    @BeforeEach
    void setUp() {
        factory = new IntArrayFactoryImpl();
    }

    @Test
    void testCreateValidIntArray() throws IntArrayException {
        int[] array = {1, 2, 3, 4, 5};
        IntArray result = factory.createIntArray(array);

        assertNotNull(result);
        assertArrayEquals(array, result.getArray());
    }

    @Test
    void testCreateIntArrayWithNull() {
        assertThrows(IntArrayException.class, () -> factory.createIntArray(null));
    }

    @Test
    void testCreateIntArrayWithEmptyArray() {
        assertThrows(IntArrayException.class, () -> factory.createIntArray(new int[]{}));
    }
}
