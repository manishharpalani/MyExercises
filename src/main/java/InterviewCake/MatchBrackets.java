package InterviewCake;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MatchBrackets {
    private static final Map<Character, Character> machingPairs = new HashMap<>();
    static {
        machingPairs.put('(', ')');
        machingPairs.put('[', ']');
        machingPairs.put('{', '}');
    };

    public static boolean isMatched(String str) {
        Stack<Character> expectedCloser = new Stack<>();
//        System.out.println(String.format("isMatched(%s) closer: %s", str, expectedCloser));

        for(Character ch: str.toCharArray()) {
            if (machingPairs.keySet().contains(ch))
                expectedCloser.push(machingPairs.get(ch));

//            System.out.println(ch + " -- " + expectedCloser);


            if (machingPairs.values().contains(ch) && !expectedCloser.empty() && expectedCloser.pop() != ch)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        System.out.println(MatchBrackets.isMatched("{ [ ] ( ) }") == true);
        System.out.println(MatchBrackets.isMatched("{ [ ( ] ) }") == false);
        System.out.println(MatchBrackets.isMatched("{ [ }") == false);
    }
}
