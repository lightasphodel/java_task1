package com.lena.task.observer.impl;

import org.apache.log4j.Logger;
import com.lena.task.entity.IntArray;
import com.lena.task.entity.IntArrayCharacteristic;
import com.lena.task.observer.Observer;
import com.lena.task.warehouse.Warehouse;

public class ObserverImpl implements Observer{
    private static final Logger logger = Logger.getLogger(ObserverImpl.class);
    @Override
    public void update(IntArray intArray) {
        IntArrayCharacteristic characteristic = new IntArrayCharacteristic(intArray);
        Warehouse.getInstance().put(intArray.getId(), characteristic);
        logger.info("Warehouse updated");
    }
}
