package InterviewCake;

/*
You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
        Write a function getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.

        For example, given:

        [1, 7, 3, 4]

        your function would return:

        [84, 12, 28, 21]

        by calculating:

        [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]

        Do not use division in your solution.
*/

import java.util.Arrays;

/**
 * Created by manishharpalani on 20/02/17.
 *
 * <ul>
 *
 * </ul>
 */
public class Q2_ProductOthers {
    /**
     * @param array
     * @return
     */
/*
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] array) {
        int[] product = new int[array.length];
        //int[] rightProd = new int[array.length];

        int leftProd = 1;
        int rightProd = 1;

        for (int ascIndex = 0 ; ascIndex < array.length; ++ascIndex) {
            int desIndex = array.length - 1 - ascIndex;
            product[ascIndex] = leftProd;
            product[desIndex] = rightProd;

            System.out.format("leftProd %d, rightProd %d, prodArr: %s\n", leftProd, rightProd, Arrays.toString(product));

            leftProd *= array[ascIndex];
            rightProd *= array[desIndex];
        }
        System.out.println("product: " + Arrays.toString(product));


//        for (int ii = array.length -1 ; ii >= 0; --ii) {
//            product[ii] *= rightProd;
//            rightProd *= array[ii];
//        }
//        System.out.println("product: " + Arrays.toString(product));

        return product;

    }
*/

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] array) {
        int[] product = new int[array.length];

        int leftProd = 1;
        for (int ii = 0 ; ii < array.length; ++ii) {
            product[ii] = leftProd;
            leftProd *= array[ii];
        }
//        System.out.println("product: " + Arrays.toString(product));

        int rightProd = 1;
        for (int ii = array.length -1 ; ii >= 0; --ii) {
            product[ii] *= rightProd;
            rightProd *= array[ii];
        }
//        System.out.println("product: " + Arrays.toString(product));


        return product;

    }
}
