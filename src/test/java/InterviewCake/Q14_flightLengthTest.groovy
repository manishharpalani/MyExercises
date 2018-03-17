package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 24/03/17.
 */
class Q14_flightLengthTest extends Specification {
    def "test flightLength"() {
        expect:
        Q14_flightLength.flightLength(100, [10, 90] as int[])
        Q14_flightLength.flightLength(100, [50, 50] as int[])
        Q14_flightLength.flightLength(100, [30, 10, 90] as int[])
        Q14_flightLength.flightLength(100, [10, 30, 90] as int[])

        !Q14_flightLength.flightLength(100, [50] as int[])
        !Q14_flightLength.flightLength(100, [] as int[])
        !Q14_flightLength.flightLength(100, [100] as int[])
        !Q14_flightLength.flightLength(100, [30, 30, 30] as int[])
        !Q14_flightLength.flightLength(100, [50, 60] as int[])
    }

//        given:
//
//        when:
//        // TODO implement stimulus
//        then:
//        // TODO implement assertions
//    }
}
