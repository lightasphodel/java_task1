package com.lena.task.repository.impl;

import com.lena.task.entity.IntArray;
import com.lena.task.repository.Specification;

public class IdSpecification implements Specification{
    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(IntArray intArray) {
        return intArray.getId() == id;
    }
}
