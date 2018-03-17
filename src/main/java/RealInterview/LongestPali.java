package RealInterview;

//Write a function that will generate one of the longest possible palindromes buildable from the characters within a given string

//For example:
//abczyx => a (any one of the characters would have been fine)
//bbaac => abcba
//aabbcc => abccba
//bbbbbaac  => bbacabb
//bbbbaac => bbacabb or abbcbba

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.lang.Object;
// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.
public class LongestPali {
    Map<Character, Integer> charCounts = new HashMap<>();

    public static void main(String[] args) {
        String str = "abbbbaxyz";
        LongestPali solution = new LongestPali(str);
        System.out.println(solution.getLongestPalindrome());
    }

    public String getLongestPalindrome() {
        StringBuilder leftHalf = new StringBuilder();
        StringBuilder center = new StringBuilder();

        for (Map.Entry<Character, Integer> entry: charCounts.entrySet()) {
            Integer count = entry.getValue();

            if (center.length() == 0 && count % 2 == 1)
                center.append(entry.getKey());

            leftHalf.append(StringUtils.repeat(entry.getKey(), count/2)); // org.apache.commons.lang3.StringUtils
        }
        return leftHalf.toString() + center.toString() + leftHalf.reverse().toString();
    }

    public LongestPali(String str) {
        for (Character ch: str.toCharArray()) {
            if (!charCounts.containsKey(ch)) {
                charCounts.put(ch, 1);
            }
            else {
                //Integer count = charCounts.get(ch);
                charCounts.put(ch, (1+charCounts.get(ch)));
            }
        }
        //System.out.println(charCounts);
    }
}


