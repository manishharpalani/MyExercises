package CodingInterviewsBook;

import java.util.Arrays;

/**
 * Created by manishharpalani on 03/02/17.
 * An array contains n numbers ranging from 0 to n-2.
 * There is exactly one number duplicated in the array.
 * How do you find the duplicated number?
 * For example, if an array with length 5 contains numbers {0, 2, 1, 3, 2}, the duplicated number is 2.
 */
public class FindDupeElem {
    public static int getDupeElem(int[] values) {
       int sum = 0;
       int n = values.length;
        for (int val: values) {
           sum += val;
       }
       System.out.format("sum(%s): %d\n", Arrays.toString(values), sum);


       return sum - calcSumTo(n-1);
    }
    public static int calcSumTo(int n) {
        //int sum = (n) * (n - 1) / 2;
        /*if (n % 2 == 1) {
            sum += (n - 1) / 2;
            System.out.println("+= " + (n - 1)/2);
        }*/
        int sum = (n * (n - 1)) >> 1;
        System.out.format("Sum of 0...%d =  %d\n", n-1, sum);
        return sum;
    }

    public static void main(String[] args)
    {
        int[] test1 = {0, 0};
        System.out.format("Expect 2: got %d\n\n", getDupeElem(test1));

        int[] test2 = {0, 1, 1};
        System.out.format("Expect 2: got %d\n\n", getDupeElem(test2));

        int[] test4 = {0, 2, 1, 3, 3};
        System.out.format("Expect 2: got %d\n\n", getDupeElem(test4));

        int[] evenN = {0, 2, 1, 3, 4, 4};
        System.out.format("Expect 2: got %d\n\n", getDupeElem(evenN));

    }
}
