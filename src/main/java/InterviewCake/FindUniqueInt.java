package InterviewCake;

import org.omg.SendingContext.RunTime;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manishharpalani on 16/02/17.
 */
public class FindUniqueInt {
    public static int findUniqueInArray(int[] droneIds) {
        if (droneIds == null)
            throw new RuntimeException();

        int uniqueDeliveryId = 0;

        for (Integer droneId: droneIds) {
            uniqueDeliveryId ^= droneId;
        }
//        if (ids.size() != 1)
//            throw new RuntimeException("Expected 1 unique id, found " + ids.size());

        return uniqueDeliveryId;
    }


    public static int findUniqueWithHashSet(int[] droneIds) {
        if (droneIds == null)
            throw new RuntimeException();

        HashSet<Integer> ids = new HashSet<>();
        for (Integer droneId: droneIds) {
            if (ids.contains(droneId))
                ids.remove(droneId);
            else
                ids.add(droneId);
        }
        if (ids.size() != 1)
            throw new RuntimeException("Expected 1 unique id, found " + ids.size());

        return ids.toArray(new Integer[0])[0];
    }
}
