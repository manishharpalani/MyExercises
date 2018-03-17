package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 24/03/17.
 */
class Q15_fibTest extends Specification {
    def "test fib"() {
        expect:
        Q15_fib.fib(0) == 0
        Q15_fib.fib(1) == 1
        Q15_fib.fib(2) == 1
        Q15_fib.fib(3) == 2
        Q15_fib.fib(4) == 3
        Q15_fib.fib(5) == 5
        Q15_fib.fib(6) == 8
        Q15_fib.fib(7) == 13
        Q15_fib.fib(8) == 21
    }

    def "negative fib"() {
        when:
        Q15_fib.fib(-1)
        then:
        thrown RuntimeException;
    }
}
