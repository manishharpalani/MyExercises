package InterviewCake;

/*
Given an arrayOfInts, find the highestProduct you can get from three of the integers.
The input arrayOfInts will always have at least three integers.
 */

import java.util.Arrays;

/**
 * Created by manishharpalani on 20/02/17.
 */
public class Q3_highestProduct {

    public static int highestProduct(int[] arrayOfInts) {
        if (arrayOfInts.length < 3)
            throw new RuntimeException("Require at least 3 elements, have " + arrayOfInts.length);

        int highBiProduct = arrayOfInts[0]*arrayOfInts[1];
        int max = Math.max(arrayOfInts[0], arrayOfInts[1]);

        int lowBiProduct = highBiProduct;
        int min = Math.min(arrayOfInts[0], arrayOfInts[1]);

        int highestTriProduct = highBiProduct * arrayOfInts[2];

        for (int ii = 2; ii < arrayOfInts.length; ++ii) {
            int curValue = arrayOfInts[ii];

            highestTriProduct = Math.max(Math.max(highestTriProduct, curValue*highBiProduct),
                    curValue*lowBiProduct);

            highBiProduct = Math.max(Math.max(highBiProduct, curValue*max),
                    curValue*min);

            lowBiProduct = Math.min(Math.min(lowBiProduct, curValue*max),
                    curValue*min);

            max = Math.max(curValue, max);
            min = Math.min(curValue, min);
        }


        return highestTriProduct;

    }

/*
    public static int highestProduct(int[] arrayOfInts) {
        if (arrayOfInts.length < 3)
            throw new RuntimeException("Require at least 3 elements, have " + arrayOfInts.length);

        int[] maxValues = {arrayOfInts[0], arrayOfInts[1], arrayOfInts[2]};
        int product = getProduct(maxValues);

        int minIndex = getMinIndex(arrayOfInts);
        for (int ii = 3; ii < arrayOfInts.length; ++ii) {
            int curValue = arrayOfInts[ii];

            if (curValue > maxValues[minIndex]) {
                maxValues[minIndex] = curValue;
                minIndex = getMinIndex(arrayOfInts);
                product = getProduct(maxValues);
            }
            else if (product < 0 && curValue > 0) {

            }
        }
        return product;
    }
*/


    public static int getProduct(int[] values) {
        int product = 1;

        for (int value: values)
            product *= value;

        return product;
    }

    public static int getMinIndex(int[] values) {
        int minIndex = values[0] < values[1] ? 0 : 1;
        return values[minIndex] < values[2] ? minIndex : 2;
    }
}
