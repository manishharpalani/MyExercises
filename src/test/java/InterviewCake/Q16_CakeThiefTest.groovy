package InterviewCake

import spock.lang.Specification
import InterviewCake.Q16_CakeThief.CakeType;

/**
 * Created by manishharpalani on 24/03/17.
 */
class Q16_CakeThiefTest extends Specification {
    def "test maxDuffelBagValue"() {

        given:
        CakeType[] cakeTypes = [
            new CakeType(7, 160),
            new CakeType(3, 90),
            new CakeType(2, 15),
            new CakeType(0, 0)];

        int capacity = 20

        expect:
        Q16_CakeThief.maxDuffelBagValue(cakeTypes, capacity) == 555

        Q16_CakeThief.maxDuffelBagValue(cakeTypes, 0) == 0

// returns 555 (6 of the middle type of cake and 1 of the last type of cake)
//        when:
        // TODO implement stimulus
//        then:
        // TODO implement assertions
    }
}
