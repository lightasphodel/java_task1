package com.lena.task.filereader;

import com.lena.task.exception.IntArrayException;

import java.util.List;

public interface AdvancedFileReader {
    List<String> readFile(String filePath) throws IntArrayException;
}
