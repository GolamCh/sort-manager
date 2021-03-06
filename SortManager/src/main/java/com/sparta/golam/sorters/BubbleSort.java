package com.sparta.golam.sorters;

import com.sparta.golam.logging.App;
import com.sparta.golam.exceptions.EmptyArrayException;
import com.sparta.golam.exceptions.SingleValueException;
import com.sparta.golam.utilities.OrderedChecker;

public class BubbleSort implements Sorter {

    public int[] sortArray(int[] arrayToSort) throws EmptyArrayException, SingleValueException {
        int arrayLength = arrayToSort.length;
        if (arrayLength == 0) {
            App.logger.error("EmptyArrayException: Empty Array");
            throw new EmptyArrayException();
        } else if (arrayLength == 1) {
            App.logger.error("SingleArrayException: Only one value");
            throw new SingleValueException();
        } else if (OrderedChecker.isOrdered(arrayToSort)) {
            return arrayToSort;
        } else {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - 1 - i; j++) {
                    if (arrayToSort[j] > arrayToSort[j + 1]) {
                        int temp = arrayToSort[j + 1];
                        arrayToSort[j + 1] = arrayToSort[j];
                        arrayToSort[j] = temp;
                    }
                }
            }
        }

        return arrayToSort;

    }




}







