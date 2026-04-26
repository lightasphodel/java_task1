package com.lena.task.repository.impl;

import java.util.OptionalDouble;

import com.lena.task.entity.IntArray;
import com.lena.task.optionality.IntArrayAction;
import com.lena.task.optionality.impl.IntArrayActionImpl;
import com.lena.task.repository.Specification;

public class AvgBetweenSpecification implements Specification {
    private static IntArrayAction action;
    private int minAvg;
    private int maxAvg;

    public AvgBetweenSpecification(int minAvg, int maxAvg) {
        if (action == null) {
            action = new IntArrayActionImpl();
        }
        this.minAvg = minAvg;
        this.maxAvg = maxAvg;
    }

    @Override
    public boolean specify(IntArray intArray) {
        OptionalDouble arrayAverage = action.average(intArray);
        return arrayAverage.isPresent() && arrayAverage.getAsDouble() >= minAvg && arrayAverage.getAsDouble() <= maxAvg;
    }
}
