package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 20/02/17.
 */
class Q3_highestProductTest extends Specification {
    def "basic_test highestProduct"() {
        expect:
        Q3_highestProduct.highestProduct([1, 7, 3, 4] as int[]) == 84
        Q3_highestProduct.highestProduct([1, 7, 3, -4] as int[]) == 21
        Q3_highestProduct.highestProduct([1, 7, 3, -4] as int[]) == 21
    }

    def "negative values highestProduct"() {
        expect:
        Q3_highestProduct.highestProduct([1, 7, 3, -4] as int[]) == 21
        Q3_highestProduct.highestProduct([-10, -10, 1, 3, 2] as int[]) == 300
        Q3_highestProduct.highestProduct([1, 10, -5, 1, -100] as int[]) == 5000
    }
}
