package CodingInterviewsBook

import spock.lang.Specification

/**
 * Created by manishharpalani on 08/02/17.
 */
class Q11_RegExTest extends Specification {
    def "dot match"() {
        when:
        Q11_RegEx regEx = new Q11_RegEx("a.a")

        then:
        regEx.match("aaa");
    }
    def "negative dot match"() {
        when:
        Q11_RegEx regEx = new Q11_RegEx("aa.a")

        then:
        !regEx.match("");
        !regEx.match("a");
        !regEx.match("aaa");
    }
/*
    def "astrisk match"() {
        Q11_RegEx regEx = new Q11_RegEx("ab*ac*a")
        expect:
        regEx.match("aaa");
    }
*/
}
