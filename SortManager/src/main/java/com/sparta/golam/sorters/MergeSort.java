package com.sparta.golam.sorters;

import com.sparta.golam.logging.App;
import com.sparta.golam.exceptions.EmptyArrayException;

public class MergeSort implements Sorter {
    public int[] sortArray(int[] arrayToSort) throws EmptyArrayException{
        if (arrayToSort.length == 0) {
            App.logger.error("EmptyArrayException: Empty Array");
            throw new EmptyArrayException("Empty Array");
        } else if (arrayToSort.length == 1) {
            return arrayToSort;
        }
        // Defining some important arrayToSort dimensions
        int arrayLength = arrayToSort.length;
        int arrayHalfLength = arrayLength / 2;
        // Creating empty arrayToSort splits
        int[] arrayR;
        int[] arrayL = new int[arrayHalfLength];
        if (arrayLength % 2 == 0) {
            // Split will be equal if arrayToSort length is even
            arrayR = new int[arrayHalfLength];
        } else {
            // First split will hold the extra value if arrayToSort length is odd
            arrayR = new int[arrayHalfLength + 1];
        }
        // Populating the arrays
        // Separate for-loops to account for possible differing arrayToSort lengths
        for (int i = 0; i < arrayL.length; i++) {
            arrayL[i] = arrayToSort[i];
        }
        for (int j = 0; j < arrayR.length; j++) {
            arrayR[j] = arrayToSort[arrayHalfLength + j];
        }
        // Creating an empty results arrayToSort
        int[] result = new int[arrayLength];
        // Recursion
        arrayL = sortArray(arrayL);
        arrayR = sortArray(arrayR);

        result = merge(arrayL, arrayR);

        return result;
    }



/*    public int[] sortArray(int[] arrayToSort){
        try {
            if (arrayToSort.length == 0) {
                throw new EmptyArrayException("Empty Array!");
            }
        } catch (EmptyArrayException e) {
            App.logger.error(e.getMessage(), e);
        } catch (Exception e) {
            App.logger.error(e);
        }
        if (arrayToSort.length <= 1) {
            return arrayToSort;
        }
        // Defining some important arrayToSort dimensions
        int arrayLength = arrayToSort.length;
        int arrayHalfLength = arrayLength / 2;
        // Creating empty arrayToSort splits
        int[] arrayR;
        int[] arrayL = new int[arrayHalfLength];
        if (arrayLength % 2 == 0) {
            // Split will be equal if arrayToSort length is even
            arrayR = new int[arrayHalfLength];
        } else {
            // First split will hold the extra value if arrayToSort length is odd
            arrayR = new int[arrayHalfLength + 1];
        }
        // Populating the arrays
        // Separate for-loops to account for possible differing arrayToSort lengths
        for (int i = 0; i < arrayL.length; i++) {
            arrayL[i] = arrayToSort[i];
        }
        for (int j = 0; j < arrayR.length; j++) {
            arrayR[j] = arrayToSort[arrayHalfLength + j];
        }
        // Creating an empty results arrayToSort
        int[] result = new int[arrayLength];
        // Recursion
        arrayL = sortArray(arrayL);
        arrayR = sortArray(arrayR);

        result = merge(arrayL, arrayR);

        return result;
    }*/

    private static int[] merge(int[] arrayL, int[] arrayR) {
        int[] result = new int[arrayL.length + arrayR.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < arrayL.length || rightIndex < arrayR.length) {
            if (leftIndex < arrayL.length && rightIndex < arrayR.length) {
                if (arrayL[leftIndex] < arrayR[rightIndex]) {
                    result[resultIndex] = arrayL[leftIndex];
                    resultIndex++;
                    leftIndex++;
                } else if (arrayL[leftIndex] == arrayR[rightIndex]) {
                    result[resultIndex] = arrayL[leftIndex];
                    resultIndex++;
                    leftIndex++;
                    result[resultIndex] = arrayR[rightIndex];
                    resultIndex++;
                    rightIndex++;
                } else {
                    result[resultIndex] = arrayR[rightIndex];
                    resultIndex++;
                    rightIndex++;
                }
            } else if (leftIndex < arrayL.length) {
                result[resultIndex] = arrayL[leftIndex];
                resultIndex++;
                leftIndex++;
            } else {
                result[resultIndex] = arrayR[rightIndex];
                resultIndex++;
                rightIndex++;
            }
        }
        return result;
    }

}
