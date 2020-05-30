import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tostw
 * No.68 文本左右对齐
 */

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int currWidth = 0;
        List<String> res = new LinkedList<>();
        List<String> currLineWords = new ArrayList<>();
        for (int i = 0, len = words.length; i < len; i++) {
            if ((currWidth + currLineWords.size() + words[i].length()) > maxWidth) {
                StringBuilder sb = new StringBuilder();
                if (currLineWords.size() == 1) {
                    sb.append(currLineWords.get(0));
                    for (int j = 0, sbLen = sb.length(); j < maxWidth - sbLen; j++) {
                        sb.append(" ");
                    }
                } else {
                    int m = (maxWidth - currWidth) / (currLineWords.size() - 1);
                    int n = (maxWidth - currWidth) % (currLineWords.size() - 1);
                    StringBuilder mSpace = new StringBuilder();
                    for (int j = 0; j < m; j++) {
                        mSpace.append(" ");
                    }

                    for (int j = 0; j < currLineWords.size() - 1; j++) {
                        sb.append(currLineWords.get(j)).append(mSpace);
                        if (j < n) {
                            sb.append(" ");
                        }
                    }
                    sb.append(currLineWords.get(currLineWords.size() - 1));
                }
                res.add(sb.toString());
                currLineWords.clear();
                currWidth = 0;
            }
            currLineWords.add(words[i]);
            currWidth += words[i].length();
        }

        if (currWidth != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < currLineWords.size() - 1; i++) {
                sb.append(currLineWords.get(i)).append(" ");
            }
            sb.append(currLineWords.get(currLineWords.size() - 1));
            for (int i = 0, sbLen = sb.length(); i < maxWidth - sbLen; i++) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] words = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask",
                "what", "you", "can", "do", "for", "your", "country"};
        List<String> res = new Solution().fullJustify(words, 16);
        for (String str : res) {
            System.out.println(str);
        }
    }
}