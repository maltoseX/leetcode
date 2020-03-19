
/**
 * @author tostw
 * 面试题01.06 字符串压缩
 */
public class Solution {
    public String compressString(String S) {
        if (S == null || S.length() <= 2) {
            return S;
        }
        char[] chs = S.toCharArray();
        int len = chs.length;
        StringBuilder sb = new StringBuilder("");
        int l = 0, r = 1;
        while (r < len) {
            if (chs[l] == chs[r]) {
                r++;
            } else {
                sb.append(chs[l]);
                sb.append(r - l);
                l = r;
                r++;
            }
        }
        sb.append(chs[l]);
        sb.append(r-l);

        return sb.length() < S.length() ? sb.toString() : S;
    }
}
