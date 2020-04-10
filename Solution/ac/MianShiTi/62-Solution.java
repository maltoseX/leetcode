import java.util.Queue;

/**
 * @author tostw
 * 面试题62. 圆圈中最后剩下的数字
 */
public class Solution {
    // 迭代法
    public int lastRemaining(int n, int m) {
        int flag = 0;
        for (int i = 2; i <= n; i++) {
            flag = (flag + m) % i;
        }
        return flag;
    }

    // 递归法
//    public int lastRemaining(int n, int m) {
//        if (n == 1) {
//            return 0;
//        }
//        return (lastRemaining(n - 1, m) + m) % n;
//    }
}

