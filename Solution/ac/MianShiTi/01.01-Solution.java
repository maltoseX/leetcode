import java.util.ArrayList;
import java.util.List;

/**
 * @author tostw
 * 面试题 01.01. 判定字符是否唯一
 */
public class Solution {
    /**
     * 方法一：利用boolean数组
     */
    public boolean isUnique(String astr) {
        boolean[] ascii = new boolean[126];

        char[] chars = astr.toCharArray();
        for (char aChar : chars) {
            if (!ascii[aChar]) {
                ascii[aChar] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二：利用位运算（假设s中仅包含26个英文字母）
     */
    public boolean isUnique2(String astr) {
        // long类型大小为8byte，共64bit
        long mark = 0L;
        int moveBit;
        for (int i = 0, len = astr.length(); i < len; i++) {
            moveBit = astr.charAt(i) - 'A';
            if ((mark & (1 << moveBit)) != 0) {
                return false;
            } else {
                mark |= (1 << moveBit);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isUnique("abc"));
    }
}