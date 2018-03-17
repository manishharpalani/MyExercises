package CodingInterviewsBook;

/**
 * Created by manishharpalani on 08/02/17.
 *
 * How do you implement a function to match regular expressions with ‘.’ and ‘*’
 * in patterns? The character ‘.’ in a pattern matches a single character, and ‘*’
 * matches zero or any number of characters preceding it. Matching means that a
 * string fully matches the pattern where all characters in a string match the
 * whole pattern. For example, the string “aaa” matches the pattern “a.a” and the
 * pattern “ab*ac*a”. However, it does not match the pattern “aa.a” nor “ab*a”.
 */
public class Q11_RegEx {

    private final String pattern;
    private int patternPos = 0;

    public Q11_RegEx(String pattern) {
        this.pattern = pattern;
    }

    public boolean match(char ch) {
        char charToMatch = pattern.charAt(patternPos);

        return (charToMatch == '.' || ch == charToMatch);
    }

    public boolean match(String string) {

        patternPos = 0;
        for (int cur = 0; cur < string.length(); ++cur) {
            if (patternPos >= pattern.length())
                return false;

            char charToMatch = pattern.charAt(patternPos);
            boolean zeroOrMore = (patternPos+1 < pattern.length()) && pattern.charAt(patternPos+1) == '*';

            if (zeroOrMore && charToMatch != string.charAt(cur)) {

            }

            if (match(string.charAt(cur))) {
            }
            else
                return false;

            ++patternPos;
        }


        return patternPos == pattern.length();
    }
}
