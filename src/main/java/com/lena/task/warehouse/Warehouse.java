package com.lena.task.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.lena.task.entity.IntArrayCharacteristic;

public class Warehouse {
    private static final Logger logger = Logger.getLogger(Warehouse.class);
    private Map<Integer, IntArrayCharacteristic> arrayDataMap = new HashMap<>();
    private Warehouse() {
    }

    private static class SingletonHolder {
        private static final Warehouse INSTANCE = new Warehouse();
    }

    public static Warehouse getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void put(int id, IntArrayCharacteristic characteristic) {
        arrayDataMap.put(id, characteristic);
        logger.info("Added characteristic");
    }

    public Optional<IntArrayCharacteristic> get(int id) {
        return Optional.ofNullable(arrayDataMap.get(id));
    }

    public void remove(int id) {
        arrayDataMap.remove(id);
        logger.info("Removed characteristic");
    }
}
