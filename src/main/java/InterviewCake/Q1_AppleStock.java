package InterviewCake;

// Writing programming interview questions hasn't made me rich.
// Maybe trading Apple stocks will.

// Suppose we could access yesterday's stock prices as an array, where:
//
// The values are the price in dollars of Apple stock.
// A higher index indicates a later time.
// So if the stock cost $500 at 10:30am and $550 at 11:00am, then:
//
// stockPricesYesterday[60] = 500;
//
// Write an efficient function that takes stockPricesYesterday and returns the best profit
// I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
//
// For example:
//
// int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
//
// getMaxProfit(stockPricesYesterday);
// // returns 6 (buying for $5 and selling for $11)
//
// No "shorting"—you must buy before you sell.
// You may not buy and sell in the same time step (at least 1 minute must pass).

/**
 * Created by manishharpalani on 19/02/17.
 *
 */
public class Q1_AppleStock {
    public static int getMaxProfit(int[] stockPrices) {
        if (stockPrices.length < 2)
            throw new RuntimeException("Need at least 2 prices to buy & sell");

        int buyPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];


        for (int index = 1 ; index < stockPrices.length; ++index) {
            int curPrice = stockPrices[index];
            int profit = curPrice - buyPrice;

            maxProfit = Math.max(profit, maxProfit);
            buyPrice = Math.min(curPrice, buyPrice);
        }


        return maxProfit;
    }
}
