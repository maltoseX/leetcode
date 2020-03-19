import java.util.Arrays;

/**
 * @author tostw
 * No.942 增减字符串匹配
 */
public class Solution {

    public int[] diStringMatch(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
//        if (S.length() == 1) {
//            if ("I".equals(S)) {
//                return new int[]{0, 1};
//            } else if ("D".equals(S)) {
//                return new int[]{1, 0};
//            }
//        }
        int len = S.length();
        char[] sch = S.toCharArray();
        int[] result = new int[len + 1];
        int iValue = 0, dValue = len;

        for (int i = 0; i < len; i++) {
            if (sch[i] == 'I') {
                result[i] = iValue++;
            } else if (sch[i] == 'D') {
                result[i] = dValue--;
            }
        }
        result[len] = iValue;
        Arrays.stream(result).forEach(System.out::print);
        return result;
    }
}
