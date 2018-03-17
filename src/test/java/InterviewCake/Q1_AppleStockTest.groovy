package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 19/02/17.
 */
class Q1_AppleStockTest extends Specification {
    def "basic getMaxProfit"() {
        expect:
        Q1_AppleStock.getMaxProfit([10, 7, 5, 8, 11, 9] as int[]) == 6
    }

    def "negative getMaxProfit"() {
        expect:
        Q1_AppleStock.getMaxProfit([10, 7] as int[]) == -3
        Q1_AppleStock.getMaxProfit([10, 7, 5] as int[]) == -2
        Q1_AppleStock.getMaxProfit([10, 7, 5, 2, 1] as int[]) == -1
    }

    def "3 prices getMaxProfit"() {
        expect:
        Q1_AppleStock.getMaxProfit([10, 10, 10, 10] as int[]) == 0
        Q1_AppleStock.getMaxProfit([10, 7, 9] as int[]) == 2
        Q1_AppleStock.getMaxProfit([10, 7, 4, 20] as int[]) == 16
        Q1_AppleStock.getMaxProfit([10, 7, 9, 20] as int[]) == 13
        Q1_AppleStock.getMaxProfit([10, 7, 9, 20, 30] as int[]) == 23
        Q1_AppleStock.getMaxProfit([40, 30, 35, 20, 26] as int[]) == 6
    }

    def "exception getMaxProfit"() {
        when:
        Q1_AppleStock.getMaxProfit([] as int[])
        then:
        thrown RuntimeException;

        when:
        Q1_AppleStock.getMaxProfit([1] as int[])
        then:
        thrown RuntimeException;
    }
}
