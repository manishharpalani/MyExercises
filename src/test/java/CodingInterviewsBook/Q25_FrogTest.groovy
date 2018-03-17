package CodingInterviewsBook

import spock.lang.Specification

/**
 * Created by manishharpalani on 05/04/17.
 */
class Q25_FrogTest extends Specification {
    def "test numberOfWays"() {
        given:

        expect:
        Q25_Frog.numberOfWays(0, [1] as int[]) == 0
        Q25_Frog.numberOfWays(1, [1] as int[]) == 1
        Q25_Frog.numberOfWays(2, [1] as int[]) == 1
        Q25_Frog.numberOfWays(3, [1] as int[]) == 1
        Q25_Frog.numberOfWays(4, [1] as int[]) == 1
        Q25_Frog.numberOfWays(5, [1] as int[]) == 1

        Q25_Frog.numberOfWays(0, [1, 2] as int[]) == 0
        Q25_Frog.numberOfWays(1, [1, 2] as int[]) == 1
        Q25_Frog.numberOfWays(2, [1, 2] as int[]) == 2
        Q25_Frog.numberOfWays(3, [1, 2] as int[]) == 3
        Q25_Frog.numberOfWays(4, [1, 2] as int[]) == 5
        Q25_Frog.numberOfWays(5, [1, 2] as int[]) == 8

        Q25_Frog.numberOfWays(0, [1, 2, 3] as int[]) == 0
        Q25_Frog.numberOfWays(1, [1, 2, 3] as int[]) == 1
        Q25_Frog.numberOfWays(2, [1, 2, 3] as int[]) == 2
        Q25_Frog.numberOfWays(3, [1, 2, 3] as int[]) == 4
        Q25_Frog.numberOfWays(4, [1, 2, 3] as int[]) == 7
        Q25_Frog.numberOfWays(5, [1, 2, 3] as int[]) == 13

        Q25_Frog.numberOfWays(4, [1, 2, 3, 4] as int[]) == 8
        Q25_Frog.numberOfWays(5, [1, 2, 3, 4, 5]  as int[]) == 16

        Q25_Frog.numberOfWays(0, [2, 3] as int[]) == 0
        Q25_Frog.numberOfWays(1, [2, 3] as int[]) == 0
        Q25_Frog.numberOfWays(2, [2, 3] as int[]) == 1
        Q25_Frog.numberOfWays(3, [2, 3] as int[]) == 1
        Q25_Frog.numberOfWays(4, [2, 3] as int[]) == 1
        Q25_Frog.numberOfWays(5, [2, 3] as int[]) == 2

//        when:
//        // TODO implement stimulus
//        then:
//        // TODO implement assertions
    }
}
