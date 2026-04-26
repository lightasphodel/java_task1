package com.lena.task.reader.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lena.task.exception.IntArrayException;
import com.lena.task.filereader.impl.AdvancedFileReaderImpl;

class AdvancedFileReaderImplTest {
    private AdvancedFileReaderImpl fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new AdvancedFileReaderImpl();
    }

    @Test
    void testReadFileWithNullPath() {
        assertThrows(IntArrayException.class, () -> fileReader.readFile(null));
    }

    @Test
    void testReadFileWithEmptyPath() {
        assertThrows(IntArrayException.class, () -> fileReader.readFile(""));
        assertThrows(IntArrayException.class, () -> fileReader.readFile("   "));
    }
}
