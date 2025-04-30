/* 121. BEST TIME TO BUY AND SELL STOCK
    You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize
    your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. if you cannot achieve any profit return 0.

    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6) , profit = 6 - 1 = 5.
                Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
    Input: prices = [7,6,4,3,1]
    Output = 0
    Explanation: in this case, no transactions are done and the max profit = 0

    Constraints:
    1 <= prices.length <= 10^5
    0 <= prices[i] <= 10^4
 */

/* UNDERSTANDING THE PROBLEM
    The price of a single stock over several days is stored in an array called prices.
    Our goal is to buy the stock on one day and sell it on a later day to make as much profit as possible.
    We are only allowed one transaction: one buy + one sell.
    We cannot sell before we buy.

    Example input: prices = [7,1,5,3,6,4]
    This means on day 0 the stock price is 7, on day 1 the stock price is 1 and so on.

    We have to find the maximum profit that you can make buying on one day and selling on another day after it. We have
    to return a single number, which is the maximum profit. If there is no way ot make profit (because prices keep going down) return 0.


 */

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args){
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfitOptimized(new int[] {7,1,5,3,6,4}));

    }

    // BRUTE FORCE SOLUTION ( VERY VERY SLOW FOR THE INPUT SIZE OF 10^5)
    public static int maxProfit(int[] prices){
        int maxProfit = 0;              // this variable keeps track of the maximum profit found so far.
        for(int i = 0; i < prices.length; i++){     // We are choosing day i to buy the stock.
            for(int j = i + 1; j < prices.length; j++){     // We are choosing the day j to sell the stock, but only on a future day (j > i)
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);     // Compares the profit with the current maximum profit.
                                                                // if its higher, maxProfit is updated. Prices[j] - [rices[i]
                                                                // calculates the profit we'd make by buying on day i and selling n day j.
            }
        }
        return maxProfit;       // return the maxProfit seen till now.
    }

    /* TIME COMPLEXITY
        O(n^2) - quadratic time
        The outer loop runs n times. the inner loop runs i+1 to n-1 each time.
        Total number of iteration = n(n-1)/2

        SPACE COMPLEXITY
        O(1) - constant space
        No extra data structures are used. only a few variables.
     */


    // OPTIMIZED SOLUTION
    public static int maxProfitOptimized(int[] prices) {
        int maxProfit = 0;          // This variable will store the maximum profit we,ve seen so far.
        int buyPrice = prices[0];       // we assume the first price is the best price initially. This will keep track of the lowest
                                        // price seen so far.
        for(int i = 0; i < prices.length; i++){         // Loop through every day's price, i is the current day we are considering to
                                                        // sell on
            int currentProfit = prices[i] - buyPrice;       // This calculates the profit if you buy at the lowest price so
                                                            // far (buyPrice) and sell today (prices[i])
            if(currentProfit > maxProfit){          //if today's profit is better than what we've seen before
                maxProfit = currentProfit;          // then update maxProfit
            }
            if(buyPrice > prices[i]){           // if today's price is lower that the lowest price we've seen before,
                buyPrice = prices[i];           // then we update buyPrice. This means that today will be the best day to buy so far.
            }
        }
        return maxProfit;               //After checking all days, return the best profit you could make from one buy-see transaction.
    }
}

/* TIME COMPLEXITY
    O(n) - linear time
    We are using a single loop to iterate through the array of prices. The loop runs from i = 0 to i = prices.length - 1
    So it runs exactly n times, where is the number of days (length of the array).
    Everything inside the loop like subtraction, comparison and assignment operations take constant time O(1).

    SPACE COMPLEXITY:
    O(1) - constant space
    We are not using any extra data structures (like arrays, hash maps, or lists).
    Only a few variables are used, which have a fixed amount of space, regardless of the input size.
 */