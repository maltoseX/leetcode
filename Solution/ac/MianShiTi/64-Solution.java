import java.util.Arrays;

/**
 * @author tostw
 * 面试题64. 求1+2+…+n
 */

class Solution {
    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}