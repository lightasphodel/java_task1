package com.lena.task.fileparser;

import com.lena.task.exception.IntArrayException;

public interface AdvancedIntParser {
  int[] parseString(String line) throws IntArrayException;
}
