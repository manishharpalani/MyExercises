package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 26/02/17.
 */
class Q5_CoinTest extends Specification {
    def "single denomination getWaysToMakeAmount"() {
        expect:
        Q5_Coin.getWaysToMakeAmount([1] as int[], 0) == 1
        Q5_Coin.getWaysToMakeAmount([1] as int[], 1) == 1
        Q5_Coin.getWaysToMakeAmount([1] as int[], 2) == 1
        Q5_Coin.getWaysToMakeAmount([1] as int[], 3) == 1
        Q5_Coin.getWaysToMakeAmount([1] as int[], 4) == 1
        Q5_Coin.getWaysToMakeAmount([1] as int[], 5) == 1

        Q5_Coin.getWaysToMakeAmount([2] as int[], 0) == 1
        Q5_Coin.getWaysToMakeAmount([2] as int[], 1) == 0
        Q5_Coin.getWaysToMakeAmount([2] as int[], 2) == 1
        Q5_Coin.getWaysToMakeAmount([2] as int[], 3) == 0
        Q5_Coin.getWaysToMakeAmount([2] as int[], 4) == 1


        Q5_Coin.getWaysToMakeAmount([3] as int[], 0) == 1
        Q5_Coin.getWaysToMakeAmount([3] as int[], 1) == 0
        Q5_Coin.getWaysToMakeAmount([3] as int[], 2) == 0
        Q5_Coin.getWaysToMakeAmount([3] as int[], 3) == 1
        Q5_Coin.getWaysToMakeAmount([3] as int[], 4) == 0
    }

    def "two denomination getWaysToMakeAmount"() {
        expect:
        Q5_Coin.getWaysToMakeAmount([1, 2] as int[], 0) == 1
        Q5_Coin.getWaysToMakeAmount([1, 2] as int[], 1) == 1
        Q5_Coin.getWaysToMakeAmount([1, 2] as int[], 2) == 2
        Q5_Coin.getWaysToMakeAmount([1, 2] as int[], 3) == 2
        Q5_Coin.getWaysToMakeAmount([1, 2] as int[], 4) == 3
        Q5_Coin.getWaysToMakeAmount([1, 2] as int[], 5) == 3
        Q5_Coin.getWaysToMakeAmount([1, 2] as int[], 6) == 4

        Q5_Coin.getWaysToMakeAmount([2, 3] as int[], 0) == 1
        Q5_Coin.getWaysToMakeAmount([2, 3] as int[], 1) == 0
        Q5_Coin.getWaysToMakeAmount([2, 3] as int[], 2) == 1
        Q5_Coin.getWaysToMakeAmount([2, 3] as int[], 3) == 1
        Q5_Coin.getWaysToMakeAmount([2, 3] as int[], 4) == 1
        Q5_Coin.getWaysToMakeAmount([2, 3] as int[], 5) == 1
        Q5_Coin.getWaysToMakeAmount([2, 3] as int[], 6) == 2
    }

        def "three denominations getWaysToMakeAmount"() {
        expect:
        Q5_Coin.getWaysToMakeAmount([1, 2, 3] as int[], 0) == 1
        Q5_Coin.getWaysToMakeAmount([1, 2, 3] as int[], 1) == 1
        Q5_Coin.getWaysToMakeAmount([1, 2, 3] as int[], 2) == 2
        Q5_Coin.getWaysToMakeAmount([1, 2, 3] as int[], 3) == 3
        Q5_Coin.getWaysToMakeAmount([1, 2, 3] as int[], 4) == 4
        Q5_Coin.getWaysToMakeAmount([1, 2, 3] as int[], 5) == 5
        Q5_Coin.getWaysToMakeAmount([1, 2, 3] as int[], 6) == 7

        Q5_Coin.getWaysToMakeAmount([1, 3, 5] as int[], 0) == 1
        Q5_Coin.getWaysToMakeAmount([1, 3, 5] as int[], 1) == 1
        Q5_Coin.getWaysToMakeAmount([1, 3, 5] as int[], 2) == 1
        Q5_Coin.getWaysToMakeAmount([1, 3, 5] as int[], 3) == 2
        Q5_Coin.getWaysToMakeAmount([1, 3, 5] as int[], 4) == 2
        Q5_Coin.getWaysToMakeAmount([1, 3, 5] as int[], 5) == 3
        Q5_Coin.getWaysToMakeAmount([1, 3, 5] as int[], 6) == 4
    }


//    def "test getWaysToMakeAmount"() {
//        given:
//
//        when:
//        // TODO implement stimulus
//        then:
//        // TODO implement assertions
//    }
}
