package com.lena.task.repository;

import org.apache.log4j.Logger;
import com.lena.task.entity.IntArray;
import com.lena.task.observer.impl.ObserverImpl;
import com.lena.task.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntArrayRepository {
    private static final Logger logger = Logger.getLogger(IntArrayRepository.class);
    private List<IntArray> intArrays = new ArrayList<>();
    private ObserverImpl observer = new ObserverImpl();

    private IntArrayRepository() {
    }

    private static class SingletonHolder {
        private static final IntArrayRepository INSTANCE = new IntArrayRepository();
    }

    public static IntArrayRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void add(IntArray intArray) {
        intArrays.add(intArray);
        intArray.attach(observer);
        observer.update(intArray);
        logger.info("Added array to repository");
    }

    public void remove(IntArray intArray) {
        if (intArrays.remove(intArray)) {
            intArray.detach(observer);
            Warehouse.getInstance().remove(intArray.getId());
            logger.info("Removed array from repository and warehouse");
        }
    }

    public List<IntArray> getIntArrays() {
        return intArrays;
    }

    public List<IntArray> query(Specification specification) {
        List<IntArray> list = intArrays.stream()
            .filter(specification::specify)
            .collect(Collectors.toList());
        return list;
    }

    public List<IntArray> sort(Comparator<IntArray> comparator) {
        List<IntArray> list = intArrays.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return list;
    }
}
