import java.util.*;

/**
 * @author tostw
 * No.50 Pow(x,n)
 * 快速幂算法
 */
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    // 递归算法
//    private double quickMul(double x, long N) {
//        if (N == 0) {
//            return 1.0;
//        }
//        double y = quickMul(x, N / 2);
//        return N % 2 == 0 ? y * y : y * y * y;
//    }

    // 迭代算法
    private double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献初始值为x
        double xContribute = x;
        // 在对N进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果N二进制表示的最低为为1，那么需要计入贡献
                ans *= xContribute;
            }
            xContribute *= xContribute;
            N /= 2;
        }

        return ans;
    }
}
