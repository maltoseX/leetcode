/**
 * @author tostw
 * No.1111 有效括号的嵌套深度
 */
public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] answer = new int[seq.length()];
        int index = 0;
        for (char ch : seq.toCharArray()) {
            answer[index++] = ch == '(' ? index & 1 : ((index + 1) & 1);
        }
        return answer;
    }
}

