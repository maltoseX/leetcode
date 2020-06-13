/**
 * @author tostw
 * No.70 爬楼梯
 */

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // p 为 n-2, q 为 n-1
        int p = 1, q = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = p + q;
            p = q;
            q = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(4));
    }
}