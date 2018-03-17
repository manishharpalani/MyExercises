package InterviewCake;

/**
 * Created by manishharpalani on 24/03/17.
 */
public class Q15_fib {

    static public int fib(int n) {
        int[] fibPrev = {0, 1};

        if (n < 0)
            throw new RuntimeException(n + ": Invalid fib index; non-negative required.");

        if (n < 2)
            return n;

        int fibCur = 0;
        for(int ii = 2; ii <= n; ++ii) {
            fibCur = fibPrev[0] + fibPrev[1];

            fibPrev[0] = fibPrev[1];
            fibPrev[1] = fibCur;
        }
        return fibCur;
    }
}


// f(2) = f(1) + f(0)
// f(3) = f(1) + f(0)
//      + f(1)
// f(4) = 2*[ f(1) + f(0)] + f(1)

// f(5) = 3*[ f(1) + f(0)] + 2*f(1)

// f(6) = 5*[ f(1) + f(0)] + 3*f(1)
