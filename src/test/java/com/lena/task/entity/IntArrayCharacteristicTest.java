package com.lena.task.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntArrayCharacteristicTest {
    private static final int[] TEST_ARRAY = {0, 1, 2, 3, 4};
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 4;
    private static final int SUM_VALUE = 10;
    private static final int AVG_VALUE = 2;

    @Test void constructorWithConstTest(){
        IntArrayCharacteristic characteristic = new IntArrayCharacteristic(MIN_VALUE, MAX_VALUE, SUM_VALUE, AVG_VALUE);

        assertEquals(MIN_VALUE, characteristic.getMin());
        assertEquals(MAX_VALUE, characteristic.getMax());
        assertEquals(SUM_VALUE, characteristic.getSum());
        assertEquals(AVG_VALUE, characteristic.getAverage());
    }

    @Test void constructorWithArrayTest(){
        IntArray intArray = new IntArray(TEST_ARRAY);
        IntArrayCharacteristic characteristic = new IntArrayCharacteristic(intArray);

        assertEquals(MAX_VALUE, characteristic.getMin());
        assertEquals(MAX_VALUE, characteristic.getMax());
        assertEquals(SUM_VALUE, characteristic.getSum());
        assertEquals(AVG_VALUE, characteristic.getAverage());
    }
}
