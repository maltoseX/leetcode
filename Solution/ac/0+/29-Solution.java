/**
 * @author tostw
 * No.29 两数相除
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MAX_VALUE;
            }
        }

        boolean minus = false;
        int result = 0;

        if (dividend > 0) {
            dividend = -dividend;
            minus = !minus;
        }
        if (divisor > 0) {
            divisor = -divisor;
            minus = !minus;
        }

        while (dividend <= divisor) {
            int times = 1;
            int i = 1;
            while (dividend <= divisor * times) {
                if (times * 10 == 1000000000) {
                    times = 1000000000;
                    break;
                }
                times *= 10;
            }

            if (times != 1000000000) {
                times /= 10;
            }

            while (dividend <= divisor * times) {
                dividend -= divisor * times;
                i++;
            }
            result += (i - 1) * times;
        }

        if (minus) {
            return -result;
        } else {
            return result;
        }
    }
}
