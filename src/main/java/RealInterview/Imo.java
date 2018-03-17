package RealInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Imo {

    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();

        int curA = 0;
        int curB = 0;

        while (curA < a.size() || curB < b.size()) {
            if (curA == a.size()) {
                result.add(b.get(curB++));
                continue;
            }

            if (curB == b.size()) {
                result.add(a.get(curA++));
                continue;
            }

            int valA = a.get(curA);
            int valB = b.get(curB);

            if (valA <= valB) {
                result.add(a.get(curA++));
            } else if (valA > valB) {
                result.add(b.get(curB++));
            }

            if (valA == valB){
                int dupe = valA;
                while(curA < a.size() && dupe == a.get(curA))
                    ++curA;
                while(curB < b.size() && dupe == b.get(curB))
                    ++curB;

            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(0, 1, 5, 7, 8, 14, 16);
        List<Integer> list2 = Arrays.asList(0, 2, 4, 8, 9, 12, 16);

        List<Integer> expected = Arrays.asList(0, 1, 2, 4, 5, 7, 8, 9, 12, 14, 16);
        List<Integer> actual = Imo.merge(list1, list2);

        System.out.println(expected);
        System.out.println(actual);
        System.out.println(expected == actual);

    }
}
