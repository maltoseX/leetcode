import java.util.Arrays;

/**
 * @author tostw
 * No.151 翻转字符串里的单词
 */
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if ("".equals(words[i])) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(words[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "the sky is blue";
//        String s = "  hello world!  ";
//        String s = "a good   example";
        String s = " ";
        System.out.println(new Solution().reverseWords(s));
    }
}