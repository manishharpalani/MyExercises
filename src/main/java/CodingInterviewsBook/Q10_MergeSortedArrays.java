package CodingInterviewsBook;

import org.omg.SendingContext.RunTimeOperations;

/**
 * Created by manishharpalani on 08/02/17.
 * Given two sorted arrays, denoted as array1 and array2, please merge them
 * into array1 and keep the merged array sorted. Suppose there is sufficient
 * vacant memory at the end of array1 to accommodate elements of array2.
 */
public class Q10_MergeSortedArrays {

    public static void merge(int[] array0, int lenArray0, int[] array1) {
        if (array0 == null || array1 == null)
            throw new RuntimeException();

        int index0 = lenArray0 - 1;
        int index1 = array1.length - 1;
        int insertPos = lenArray0 + array1.length - 1;

        while (index0 >= 0 && index1 >= 0) {
                array0[insertPos--] = (array0[index0] > array1[index1])
                                        ? array0[index0--]
                                        : array1[index1--];
        }
        while (index1 >= 0)
            array0[insertPos--] = array1[index1--];
    }
}
