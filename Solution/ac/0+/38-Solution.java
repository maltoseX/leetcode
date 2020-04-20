/**
 * @author tostw
 * No.38 外观数列
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String str = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            char ch = str.charAt(0);
            int times = 0;
            for (int i = 0, len = str.length(); i < len; i++) {
                if (ch == str.charAt(i)) {
                    times++;
                } else {
                    sb.append(times);
                    sb.append(ch);
                    ch = str.charAt(i);
                    times = 1;
                }
            }
            sb.append(times);
            sb.append(ch);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }
}