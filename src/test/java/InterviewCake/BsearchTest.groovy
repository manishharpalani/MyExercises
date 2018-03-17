package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 05/03/17.
 */
class BsearchTest extends Specification {
    def "test exists"() {
        expect:
        Bsearch.exists(null as int[], 7) == false
        Bsearch.exists([] as int[], 7) == false
        Bsearch.exists([1, 10] as int[], 7) == false
        Bsearch.exists([1, 7, 10] as int[], 7) == true

        Bsearch.exists([1, 2, 4, 7, 10] as int[], 7) == true
        Bsearch.exists([7, 10, 20, 100] as int[], 7) == true
        Bsearch.exists([-100, -30, -10, 7] as int[], 7) == true
        Bsearch.exists([1, 2, 3, 4, 5, 6, 8, 9, 10, 11] as int[], 7) == false
    }

    def "exceptions findRotationPoint"() {
        when:
        Bsearch.findRotationPoint(null)

        then:
        thrown RuntimeException

        when:
        Bsearch.findRotationPoint([] as String[])

        then:
        thrown RuntimeException

    }
    def "findRotationPoint"() {
        expect:
        Bsearch.findRotationPoint(["ptolemaic"] as String[]) == 0
        Bsearch.findRotationPoint(["ptolemaic", "ptolemaic"] as String[]) == 0
        Bsearch.findRotationPoint(["ptolemaic", "retrograde"] as String[]) == 0
        Bsearch.findRotationPoint(["retrograde", "ptolemaic"] as String[]) == 1
        Bsearch.findRotationPoint(["c", "d", "e", "f", "a", "b", "c"] as String[]) == 4
        Bsearch.findRotationPoint(["d", "e", "f", "a", "b", "c"] as String[]) == 3
        Bsearch.findRotationPoint(["a", "b", "c", "d", "e", "f", "g"] as String[]) == 0

        Bsearch.findRotationPoint(["ptolemaic","retrograde","supplant","undulate","xenoepist",
                 // <-- rotates here!
                 "asymptote","babka","banoffee","engender","karpatka","othellolagkage"] as String[]) == 5

    }
}
