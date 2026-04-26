package com.lena.task.comparator;

import com.lena.task.entity.IntArray;
import java.util.Comparator;

public enum IntArrayComparator implements Comparator<IntArray>{
    BY_ID {
        @Override
        public int compare(IntArray o1, IntArray o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    },
    BY_ELEMENTS_AMOUNT {
        @Override
        public int compare(IntArray o1, IntArray o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    } /*  ,
    BY_FIRST_ELEMENT {
        @Override
        public int compare(IntArray o1, IntArray o2) {
            return Integer.compare(o1.getElement(0), o2.getElement(0));
        }
    }*/
}
