/**
 * Solution No.122 买卖股票II
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = { 3, 2, 6, 5, 0, 3 };
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int profit = Integer.MAX_VALUE;

        return profit;
    }
}