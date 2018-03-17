package CodingInterviewsBook;

/**
 * Created by manishharpalani on 30/01/17.
 */
public class Palindrome {
    public static boolean isPalindrome(String str) {

        if (str == null)
            return true;

        for(int leftPos = 0; leftPos < str.length()/2; ++leftPos) {
            int rightPos = str.length() - 1 - leftPos;
            if (str.charAt(leftPos) != str.charAt(rightPos))
                return false;
        }
        return true;
    }
    public static boolean isPalindrome(int num) {
        return num == reverse(num);
    }
    public static int reverse(final int num) {
        int numCopy = num;
        int reverse = 0;
        while (numCopy > 0) {
            reverse = reverse*10 + numCopy % 10;
            numCopy /= 10;
        }
        return reverse;
    }
}
