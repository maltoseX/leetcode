/**
 * Solution
 * No.121 买卖股票
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int min = prices[0], max = prices[0];
        for (int i = 1, len = prices.length; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
                int newProfit = max - min;
                if (profit < newProfit) {
                    profit = newProfit;
                }
            }
        }
        return profit;
    }
}