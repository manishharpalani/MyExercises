package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 16/02/17.
 */
class FindUniqueIntTest extends Specification {
    def "null ids"() {
        when:
        int[] ids = null
        int uniqueId = FindUniqueInt.findUniqueInArray(ids)
        then:
        thrown RuntimeException
    }

    def "single id"() {
        expect:
        int[] ids = [3]
        FindUniqueInt.findUniqueInArray(ids) == 3
    }

    def "multiple ids"() {
        expect:
        int[] ids = [1, 3, 4, 4, 1]
        FindUniqueInt.findUniqueInArray(ids) == 3
    }

    def "no unique id"() {
        int[] ids = [1, 2, 3, 1, 2, 3]
        when:
        int uniqueId = FindUniqueInt.findUniqueInArray(ids)
        then:
        uniqueId == 0
    }

    def "multi unique ids"() {
        when:
        int[] ids = [1, 3, 5, 9, 3]
        int uniqueId = FindUniqueInt.findUniqueInArray(ids)
        then:
        uniqueId == (1 ^ 5 ^ 9)
    }

}
