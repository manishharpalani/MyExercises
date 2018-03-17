package InterviewCake;

import java.util.*;

/**
 * Created by manishharpalani on 26/02/17.
 */
public class Q5_Coin {

    private HashMap<Integer, List<List<Integer>>> coinsToMakeAmount = new HashMap<>();
    private int[] denominations;

    public Q5_Coin(int[] denominations) {
        this.denominations = denominations;
        //Arrays.sort(denominations, Collections.reverseOrder());


    }

    public static int getWaysToMakeAmount(int[] denominations, int amount) {
        int[] waysToMakeAmount = new int[amount + 1];
//        List<Integer> waysToMakeAmount = new ArrayList<>();
        waysToMakeAmount[0] = 1;
        for (int denomination: denominations) {
            for (int ii = 1; ii <= amount; ++ii) {
                int extraWays = 0;
//                if (ii % denomination == 0)
                if (ii >= denomination)
                    waysToMakeAmount[ii] += waysToMakeAmount[ii - denomination];
            }
        }
        return waysToMakeAmount[amount];
    }

//    static class State {
//        int amountLeft;
//        int index;
//    }
//
//    public static int getWaysToMakeAmount(int[] denominations, int amountLeft) {
//        int index = 0;
//
//        int numWays = 0;
//        while (amountLeft >= 0) {
//                        numWays += getWaysToMakeAmount(denominations, amountLeft, index + 1);
//            amountLeft -= denominations[index];
//        }
//        return numWays;
//
//    }
//    public static int getWaysToMakeAmount(int[] denominations, int amountLeft, int index) {
//
//        if (amountLeft == 0)
//            return 1;
//        else if (amountLeft < 0)
//            return 0;
//
//        if (index >= denominations.length)
//            return 0;
//
//        int numWays = 0;
//        while (amountLeft >= 0) {
//            numWays += getWaysToMakeAmount(denominations, amountLeft, index + 1);
//            amountLeft -= denominations[index];
//        }
//        return numWays;
//
//    }
}
    /*
    private void waysForAmount(int amount, List<List<Integer>> coins) {
        for(int denomination: denominations) {
            if (denomination > amount)
                break;
            List<Integer> wayToMakeAmount = new LinkedList<>();
            for (int ii = denomination; ii <= amount; ii += denomination) {
                wayToMakeAmount.add(denomination);
                if (ii < amount) {

                }
                if (ii == amount) {
                    coins.add(wayToMakeAmount);
                    break;
                }
            }
        }
        coinsToMakeAmount.put(amount, coins);
    }

    public static int getWaysToMakeAmount(int[] denominations, int amount) {
        List<List<Integer>> coins = new ArrayList<>();

        Q5_Coin q5 = new Q5_Coin(denominations);

        for (int ii = 1; ii <= amount; ++ii) {
            //q5.coinsToMakeAmount.put(ii, );
            q5.waysForAmount(ii, new ArrayList<>());
        }

        return q5.coinsToMakeAmount.get(amount).size();


        List<Integer> denomList = Arrays.asList(denominations);

        for (int ii = 1; ii <= amount; ++ii) {
            if (denomList.contains(ii)) {
                coins.add(Arrays.asList(ii));
            }
            for(List<Integer> values: coins) {
                values.add(1);
            }

        }

        return coins.size();
    }
}
*/
