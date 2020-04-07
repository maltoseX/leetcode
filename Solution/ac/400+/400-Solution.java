/**
 * @author tostw
 * No.400 第N个数字
 */
public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long digitLen = 1;
        long i = 1;
        long prevDigitLen = 9;
        while (n > prevDigitLen) {
            n -= prevDigitLen;
            i *= 10;
            digitLen += 1;
            prevDigitLen = 9 * i * digitLen;
        }
        return String.valueOf(i + (n - 1) / digitLen).charAt((int) ((n-1) % digitLen)) - 48;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().findNthDigit(2890));
//        System.out.println(new Solution().findNthDigit(2891));
        // 2147483647
        System.out.println(new Solution().findNthDigit(Integer.MAX_VALUE));
    }
}