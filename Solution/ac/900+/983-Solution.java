/**
 * @author tostw
 * No.983 最低票价
 */
class Solution {
    int[] days, costs;
    Integer[] memo;
    int[] durations = {1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;

        memo = new Integer[days.length];
        return dp(0);
    }

    private int dp(int i) {
        if (i >= days.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        memo[i] = Integer.MAX_VALUE;
        int j = i;

        for (int k = 0; k < 3; ++k) {
            while (j < days.length && days[j] < days[i] + durations[k]) {
                j++;
            }
            memo[i] = Math.min(memo[i], dp(j) + costs[k]);
        }
        return memo[i];
    }
}
