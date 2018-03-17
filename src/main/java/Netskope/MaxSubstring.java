package Netskope;

/**
 * Created by manishharpalani on 31/01/17.
 */
public class MaxSubstring {
    public static String answer(String string_a, String string_b) {
        String ans1 = subAnswer(string_a, string_b);
        String ans2 = subAnswer(string_b, string_a);
        return (ans1.length() > ans2.length()) ? ans1 : ans2;
    }

    String maxSubstring = "";
    public String getMaxSubstring(String string_a, String string_b) {
        maxSubstring = "";
        for (int ii = 0; ii < string_b.length(); ++ii)
            updateMaxSubstring(string_a, string_b, ii);

        for (int ii = 1; ii < string_a.length(); ++ii)
            updateMaxSubstring(string_b, string_a, ii);

        return maxSubstring;
    }
    private void updateMaxSubstring(String string_a, String string_b, int bStartPos) {
        int length = Math.min(string_a.length(), string_b.length() - bStartPos);

        StringBuffer matchString = new StringBuffer();
        for (int cur = 0; cur < length; ++cur) {
            if (string_a.charAt(cur) == string_b.charAt(cur + bStartPos)) {
                matchString.append(string_a.charAt(cur));
            }
            else {
                if (matchString.length() > maxSubstring.length()) {
                    maxSubstring = matchString.toString();
                }
                matchString = new StringBuffer();
            }
        }

        if (matchString.length() > maxSubstring.length()) {
            maxSubstring = matchString.toString();
        }
    }

    private static String subAnswer(String string_a, String string_b) {
        String maxSubstring = "";
        for (int ii = 0; ii < string_a.length() ; ++ii) {
            int startA = ii;
            int lengthA = string_a.length() - ii;

            int startB = 0;
            int lengthB = string_b.length();

            int length = Math.min(lengthA, lengthB);

            /*
            System.out.format("compare %s %s\n",
                    string_a.substring(startA, string_a.length()),
                    string_b.substring(startB, string_b.length()));*/


            StringBuffer matchString = new StringBuffer();
            for (int cur = 0; cur < length; ++cur) {
                if (string_a.charAt(startA + cur) == string_b.charAt(startB + cur)) {
                    matchString.append(string_a.charAt(startA + cur));

                    if (matchString.length() > maxSubstring.length()) {
                        maxSubstring = matchString.toString();
                        //System.out.format("maxSubstring %s\n", maxSubstring);
                    }
                    // System.out.format("match at %d: %c\n", cur, string_a.charAt(startA + cur));
                }
                else
                    matchString = new StringBuffer();
            }
        }

        return maxSubstring;
    }

    /**
     * 01234567890123
     *    StrAA
     * StrB
     *
     *    StrAA
     *    StrB
     *
     *    StrAA
     *     StrB
     *
     *    StrAA
     *        StrB
     * @param string_a
     * @param string_b
     * @return
     */
    private static String answer2(String string_a, String string_b) {
        String maxSubstring = "";
        int end = string_b.length() + string_a.length() - 2;
        for (int ii = 0; ii <= end ; ++ii) {
            int startA = ii < string_b.length() ? 0 : ii - string_b.length() + 1;
            int startB = ii < string_b.length() ? string_b.length() - 1 - ii : 0;

            int lengthA = string_a.length() - startA;


            int lengthB = string_b.length() - startB;

            int length = Math.min(lengthA, lengthB);

//            System.out.format("compare ii=%d stringA(%d, %d) stringB(%d, %d)\n"
//                    , ii
//                    , startA, lengthA
//                    , startB, lengthB);

            System.out.format("compare ii=%d lenght=%d stringA=%s stringB=%s\n"
                    , ii, length
                    , string_a.substring(startA, startA + length)
                    , string_b.substring(startB, startB + length));


            StringBuffer matchString = new StringBuffer();
            for (int cur = 0; cur < length; ++cur) {
                if (string_a.charAt(startA + cur) == string_b.charAt(startB + cur)) {
                    matchString.append(string_a.charAt(startA + cur));

                    if (matchString.length() > maxSubstring.length()) {
                        maxSubstring = matchString.toString();
                        //System.out.format("maxSubstring %s\n", maxSubstring);
                    }
                    // System.out.format("match at %d: %c\n", cur, string_a.charAt(startA + cur));
                }
                else
                    matchString = new StringBuffer();
            }
        }

        return maxSubstring;
    }


    public static void main(String[] args)
    {
        System.out.println(answer("Hello, World!", "hello Hello!"));
        //System.out.println(answer("hello Hello!", "Hello, World!"));
        System.out.println(answer("TTTAAAGGG", "AAA"));
        //System.out.println(answer("AAA", "TTTAAAGGG"));
        System.out.println(answer("TTTZZZGGG", "AAA"));
    }
}
