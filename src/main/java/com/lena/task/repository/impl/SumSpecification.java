package com.lena.task.repository.impl;

import com.lena.task.entity.IntArray;
import com.lena.task.optionality.IntArrayAction;
import com.lena.task.optionality.impl.IntArrayActionImpl;
import com.lena.task.repository.Specification;

import java.util.OptionalInt;

public class SumSpecification implements Specification {
    private static IntArrayAction action;
  private int sum;

  public SumSpecification(int sum) {
    if (action == null) {
      action = new IntArrayActionImpl();
    }
    this.sum = sum;
  }

  @Override
  public boolean specify(IntArray intArray) {
    OptionalInt arraySum = action.sum(intArray);
    return arraySum.isPresent() && arraySum.getAsInt() == sum;
  }
}
