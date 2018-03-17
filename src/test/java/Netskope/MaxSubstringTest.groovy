package Netskope

import spock.lang.Specification

/**
 * Created by manishharpalani on 08/02/17.
 */
class MaxSubstringTest extends Specification {
    def "test answer"() {
        expect:
        MaxSubstring.answer("Hello, World!", "hello Hello!") == "Hello"
        MaxSubstring.answer("TTTAAAGGG", "AAA") == "AAA"
        MaxSubstring.answer("TTTZZZGGG", "AAA") == ""
        MaxSubstring.answer("TTTZZZGGG", "") == ""
        MaxSubstring.answer("", "HELLO") == ""
        MaxSubstring.answer("", "") == ""
    }
    def "test answer2"() {
        expect:
        MaxSubstring.answer2("Hell", "hello") == "ell"
        MaxSubstring.answer2("Hello, World!", "hello Hello!") == "Hello"
        MaxSubstring.answer2("TTTAAAGGG", "AAA") == "AAA"
        MaxSubstring.answer2("TTTZZZGGG", "AAA") == ""
        MaxSubstring.answer2("TTTZZZGGG", "") == ""
        MaxSubstring.answer2("", "HELLO") == ""
        MaxSubstring.answer2("", "") == ""
    }

    def "test getMaxSubstring"() {
        expect:
        MaxSubstring maxSubstring = new MaxSubstring();
        maxSubstring.getMaxSubstring("Hell", "hello") == "ell"
        maxSubstring.getMaxSubstring("Hello, World!", "hello Hello!") == "Hello"
        maxSubstring.getMaxSubstring("TTTAAAGGG", "AAA") == "AAA"
        maxSubstring.getMaxSubstring("TTTZZZGGG", "AAA") == ""
        maxSubstring.getMaxSubstring("TTTZZZGGG", "") == ""
        maxSubstring.getMaxSubstring("", "HELLO") == ""
        maxSubstring.getMaxSubstring("", "") == ""
    }
}
