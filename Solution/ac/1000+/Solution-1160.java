import java.util.HashSet;
import java.util.Set;

/**
 * @author tostw
 * No.1160 拼写单词
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        if (words == null || words.length == 0 || chars == null || chars.length() == 0) {
            return 0;
        }
        int[] charsArr = new int[26];
        for (char ch : chars.toCharArray()) {
            charsArr[ch - 'a'] += 1;
        }
        int result = 0;
        for (String word : words) {
            if (canSpellWords(word, charsArr)) {
                result += word.length();
            }
        }
        return result;
    }

    public boolean canSpellWords(String word, int[] charsArr) {
        int[] temp = new int[26];
        for (int i = 0, len = word.length(); i < len; i++) {
            char now = word.charAt(i);
            if (temp[now - 'a'] == charsArr[now - 'a']) {
                return false;
            }
            temp[now - 'a']++;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hello", "world", "leetcode"};
        String chars = "weldonehoneyr";
        System.out.println(new Solution().countCharacters(words, chars));

    }
}
