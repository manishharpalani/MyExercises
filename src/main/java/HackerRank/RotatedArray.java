package HackerRank;

import java.io.*;
import java.util.*;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class RotatedArray {

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.

     * login/logout time
     * status bit
     * boolean canDrive(list<shifts> times)
     * [(1, 5), (6, 10), (10, 14)]
     */

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int left = 0;
        int lVal = nums[left];

        int right = nums.length-1;
        int rVal = nums[right];

        while (left <= right) {
            System.out.println(String.format("%d %d - %d", target, left, right));
            if (lVal == target)
                return left;
            left++;

            if (rVal == target)
                return right;
            right--;

            // ???
            if (rVal >= lVal)
                return bSearch(nums, left, right, target);

            int mid = (left + right)/2;
            int mVal = nums[mid];

            if (mVal == target)
                return mid;

            if (lVal < target && target < mVal) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }

        return -1;



        // int mid = (left + right)/2;
        // int prev = (right + lo)/2;
        // int prevVal = nums[cur];
    }

    public int search(int[] nums, int left, int right, int target) {
        System.out.println(String.format("bSearch %d - %d, target: %d", left, right, target));
        while (right >= left) {
            int mid = (left + right)/2;
            int midVal = nums[mid];

            if (midVal == target)
                return mid;

            int lValue = nums[left];
            if (lValue < midVal ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println("left: " + left + ", right= " + right);
        }
        return -1;

    }

    public int bSearch(int[] nums, int left, int right, int target) {
        System.out.println(String.format("bSearch %d - %d, target: %d", left, right, target));
        while (right >= left) {
            int mid = (left + right)/2;
            int midVal = nums[mid];

            if (midVal == target)
                return mid;

            if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println("left: " + left + ", right= " + right);
        }
        return -1;

    }
    @Test
    public void findExisting() {
        RotatedArray sol = new RotatedArray();

        int[] arr = {6, 8, 10, 2, 4};
        for (int ii = 0; ii < arr.length; ++ii)
            Assert.assertTrue(sol.search(arr, arr[ii]) == ii);
    }

    @Test
    public void missingElement() {
        RotatedArray sol = new RotatedArray();
        int[] arr = {6, 8, 10, 2, 4};

        Assert.assertTrue(sol.search(arr, 1) == -1);
        Assert.assertTrue(sol.search(arr, 3) == -1);
        Assert.assertTrue(sol.search(arr, 5) == -1);
        Assert.assertTrue(sol.search(arr, 7) == -1);
        Assert.assertTrue(sol.search(arr, 50) == -1);
    }
}
