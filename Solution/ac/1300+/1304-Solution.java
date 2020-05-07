/**
 * @author tostw
 * No.1304 和为零的N个唯一整数
 */
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        int i = n % 2 == 0 ? 1 : 0;
        for (int j = n / 2; j >= 0; j--, i++) {
            res[j] = -i;
            res[n - j - 1] = i;
        }
        return res;
    }
}
