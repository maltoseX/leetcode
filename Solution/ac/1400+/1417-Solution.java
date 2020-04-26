import java.util.Arrays;

/**
 * @author tostw
 * No.1417 重新格式化字符串
 */
class Solution {
    public String reformat(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int numOfLetter = 0;
        char[] letter = new char[len];
        int numOfNumber = 0;
        char[] number = new char[len];

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                letter[numOfLetter++] = s.charAt(i);
            } else {
                number[numOfNumber++] = s.charAt(i);
            }
        }

        if (Math.abs(numOfLetter - numOfNumber) > 1) {
            return "";
        } else {
            letter = Arrays.copyOf(letter, numOfLetter);
            number = Arrays.copyOf(number, numOfNumber);
            return numOfLetter > numOfNumber ? merge(letter, number) : merge(number, letter);
        }
    }

    private String merge(char[] chars1, char[] chars2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0, len = chars2.length; i < len; i++) {
            sb.append(chars1[i]);
            sb.append(chars2[i]);
        }
        if (chars1.length > chars2.length) {
            sb.append(chars1[chars1.length - 1]);
        }

        return sb.toString();
    }
}