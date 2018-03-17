package InterviewCake;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manishharpalani on 24/03/17.
 */
public class Q16_CakeThief {
    static class CakeType {

        int weight;
        int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }

    }
    static public int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
        Map<Integer, Integer> cakeValues = new HashMap<>();
        for (CakeType cake: cakeTypes) {
            cakeValues.put(cake.weight, cake.value);
        }


        Map<Integer, Integer> valueForCapacity = new HashMap<>();

        for (int curCapacity = 0 ; curCapacity <= capacity; ++curCapacity) {
            Integer maxForCur = 0;

            if (cakeValues.containsKey(curCapacity))
                maxForCur = cakeValues.get(curCapacity);

            for(int weight = 1; curCapacity > 1 && weight <= curCapacity/2; ++weight) {
                Integer value = valueForCapacity.get(weight) + valueForCapacity.get(curCapacity - weight);
                maxForCur = Math.max(maxForCur, value);
            }
            valueForCapacity.put(curCapacity, maxForCur);

        }

        return valueForCapacity.get(capacity);

    }
}
