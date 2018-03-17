package InterviewCake;

/**
 * Created by manishharpalani on 05/03/17.
 */
public class Bsearch {

    /**
     * Q12 - https://www.interviewcake.com/question/java/find-in-ordered-set
     *
     * Suppose we had an array ↴ of nn integers sorted in ascending order.
     * How quickly could we check if a given integer is in the array?
     * @param sorted
     * @param value
     * @return
     */
    static public boolean exists(int[] sorted, int value) {
        if (sorted == null)
            return false;

        int lowerIndex = 0;
        int upperIndex = sorted.length - 1;

        while (lowerIndex <= upperIndex) {
            int midIndex = (lowerIndex + upperIndex)/2;

            if (sorted[midIndex] == value)
                return true;

            if (sorted[midIndex] > value)
                upperIndex = midIndex - 1;
            else
                lowerIndex = midIndex + 1;
        }

        return false;

    }

    //

    /**
     * Q13
     * https://www.interviewcake.com/question/java/find-rotation-point
     * @param words
     * @return
     */
    static public int findRotationPoint(String[] words) {
        if (words == null)
            throw new RuntimeException("No words - no rotation point");

        int lowerIndex = 0;
        int upperIndex = words.length - 1;
        String firstWord = words[0];

        while (lowerIndex <= upperIndex) {
            int midIndex = (lowerIndex + upperIndex) / 2;
            int compare = firstWord.compareTo(words[midIndex]);
            if (compare > 0) { // midIndex is at or past rotation
                if (midIndex == lowerIndex)
                    return midIndex;
                upperIndex = midIndex;
            }
            if (compare <= 0) { // miIndex is before the rotation
                lowerIndex = midIndex + 1;
            }
        }
        return 0;

    }


}
