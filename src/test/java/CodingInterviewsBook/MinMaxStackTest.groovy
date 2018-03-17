package CodingInterviewsBook

import spock.lang.Specification

/**
 * Created by manishharpalani on 06/04/17.
 */
class MinMaxStackTest extends Specification {
    def "test push"() {
        given:
        MinMaxStack stack = new MinMaxStack();

        when:
        stack.push(1)
        stack.push(5)
        stack.push(5)
        stack.push(5)

        then:
        stack.getMax() == 5;

        stack.pop();
        stack.getMax() == 5;

        stack.pop();
        stack.getMax() == 5;

        stack.pop();
        stack.getMax() == 1;

    }

//    def "test pop"() {
//        given:
//
//        when:
//        // TODO implement stimulus
//        then:
//        // TODO implement assertions
//    }
//
//    def "test getMin"() {
//        given:
//
//        when:
//        // TODO implement stimulus
//        then:
//        // TODO implement assertions
//    }
//
//    def "test getMax"() {
//        given:
//
//        when:
//        // TODO implement stimulus
//        then:
//        // TODO implement assertions
//    }
}
