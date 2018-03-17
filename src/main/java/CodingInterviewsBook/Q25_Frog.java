package CodingInterviewsBook;

/**
 * Created by manishharpalani on 05/04/17.
 */
public class Q25_Frog {

    static int numberOfWays(int levels, int[] moves) {
        int numWays[] = new int[levels + 1];
        numWays[0] = 0;

        for (int ii = 1; ii <= levels; ++ii) {
            int ways = 0;
            for (int numSteps: moves) {
                if (numSteps > ii)
                    continue;

                if (numSteps < ii) {
                    ways += numWays[ii - numSteps];
                }
                else
                    ++ways;

            }
            numWays[ii] = ways;
        }

        return numWays[levels];
    }
}
