/**
 * @author tostw
 * No.29 两数相除
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }

        boolean negative = false;
        if (dividend > 0) {
            dividend = -dividend;
            negative = true;
        }
        if (divisor > 0) {
            divisor = -divisor;
            negative = !negative;
        }

        int ans = 0;
        int times;
        int tempDivisor;
        while (dividend <= divisor) {
            times = 1;
            tempDivisor = divisor;
            while (dividend <= tempDivisor) {
                dividend -= tempDivisor;
                ans += times;
                if (tempDivisor < Integer.MAX_VALUE - tempDivisor) {
                    tempDivisor  <<= 1;
                    times <<= 1;
                }
            }
        }
        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(Integer.MAX_VALUE, 2));
    }
}