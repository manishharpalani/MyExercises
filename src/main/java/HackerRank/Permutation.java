package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> current = new ArrayList<List<Integer>>();

        if (nums.length == 0)
            return current;

        current.add(new ArrayList<Integer>());

        List<List<Integer>> next = new ArrayList<List<Integer>>();

        for(int ii=0; ii<nums.length; ++ii) {
            for (List<Integer> item : current) {
                for (Integer curNum : nums) {
                    if (!item.contains(curNum)) {
                        List<Integer> withCurNum = new ArrayList<Integer>(item);
                        withCurNum.add(curNum);
                        next.add(withCurNum);
                    }
                }
            }
            current = next;
            next = new ArrayList<List<Integer>>();

        }
        return current;
    }
}
