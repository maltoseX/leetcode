/**
 * @author tostw
 * No.365 水壶问题
 * 证明见 MIT6.042 Lecture4 Number Theory1
 * https://www.bilibili.com/video/av46506390?p=4
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (a * b != 0) {
            if (a > b) {
                a %= b;
            } else{
                b %= a;
            }
        }
        return Math.max(a, b);
    }
}
