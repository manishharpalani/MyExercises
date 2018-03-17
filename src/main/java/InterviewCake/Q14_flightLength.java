package InterviewCake;

import java.util.HashSet;

/**
 * Created by manishharpalani on 24/03/17.
 You've built an in-flight entertainment system with on-demand movie streaming.
 Users on longer flights like to start a second movie right when their first one ends, but they complain that the plane usually lands before they can see the ending. So you're building a feature for choosing two movies whose total runtimes will equal the exact flight length.

 Write a function that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes) and returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.

 When building your function:

 Assume your users will watch exactly two movies
 Don't make your users watch the same movie twice
 Optimize for runtime over memory
 */

public class Q14_flightLength {

    static boolean flightLength(int flightLength, int[] movieLengths) {
        HashSet<Integer> movieTime = new HashSet<>();

        for (Integer movieLength: movieLengths) {
            Integer remainingTime = flightLength - movieLength;
            if (movieTime.contains(remainingTime))
                return true;
            movieTime.add(movieLength);
        }

        return false;
    }

}
