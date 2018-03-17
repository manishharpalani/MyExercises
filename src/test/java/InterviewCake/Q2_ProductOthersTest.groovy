package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 20/02/17.
 */
class Q2_ProductOthersTest extends Specification {
    def "basic getProductsOfAllIntsExceptAtIndex"() {
        expect:
        Q2_ProductOthers.getProductsOfAllIntsExceptAtIndex([1, 7, 3, 4] as int[]) == [84, 12, 28, 21]
        Q2_ProductOthers.getProductsOfAllIntsExceptAtIndex([1, 7, 3, 0, 4] as int[]) == [0, 0, 0, 84, 0]
        Q2_ProductOthers.getProductsOfAllIntsExceptAtIndex([2, 3] as int[]) == [3, 2]

        Q2_ProductOthers.getProductsOfAllIntsExceptAtIndex([2] as int[]) == [1]
        Q2_ProductOthers.getProductsOfAllIntsExceptAtIndex([] as int[]) == []
    }
}
