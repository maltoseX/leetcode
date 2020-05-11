/**
 * @author tostw
 * No.1217 玩筹码
 */
class Solution {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for (int i = 0, len = chips.length; i < len; i++) {
            if (chips[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd,even);
    }
}