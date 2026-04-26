package com.lena.task.entity;

import org.apache.log4j.Logger;
import com.lena.task.exception.IntArrayException;
import com.lena.task.util.IdGenerator;
import com.lena.task.observer.Observer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class IntArray {
  private static final Logger logger = Logger.getLogger(IntArray.class);
  private final int id;
  private int[] array;
  private final List<Observer> observers = new ArrayList<>();

  public IntArray(int[] array) {
    this.id = IdGenerator.getId();
    this.array = array.clone();
    logger.info("IntArray has been created");
  }

  public int getId(){
    return id;
  }

  public int length() {
    return array.length;
  }

  public int[] getArray() {
    return array.clone();
  }

  public void setElement(int index, int value) throws IntArrayException {
    if ((index < 0) || (index >= array.length)) {
        throw new IntArrayException("Index is out of range" + index);
    }

    if (array[index] != value) {
        array[index] = value;
        notifyObservers();
        logger.info("The value has been updated");
    }
  }

  public int getElement(int index) throws IntArrayException {
    if ((index < 0) || (index >= array.length)) {
        throw new IntArrayException("Index is out of range" + index);
    }
    return array[index];
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof IntArray other)) return false;
    return Arrays.equals(array, other.getArray());
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(id);
  }

  @Override
  public String toString() {
    return "IntArray{id=" + id + ", length=" + array.length + "}";
  }

  public void attach(Observer observer) {
    if (!observers.contains(observer)) {
      observers.add(observer);
      logger.info("Observer attached to IntArray");
    }
  }

  public void detach(Observer observer) {
    if (observers.remove(observer)) {
      logger.info("Observer detached from IntArray");
    }
  }

  private void notifyObservers() {
    if (!observers.isEmpty()) {
      logger.info("Notifying observers for IntArray");
      for (Observer observer : observers) {
        observer.update(this);
      }
    }
  }
}
