import java.util.Arrays;

/**
 * @author tostw
 * 面试题 16.18. 模式匹配
 */
public class Solution {
    public boolean patternMatching(String pattern, String value) {
        if ("a".equals(pattern) || "b".equals(pattern)) {
            return true;
        }
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        char[] pChars = pattern.toCharArray();
        char[] vChars = value.toCharArray();

        if (value.length() == 0) {
            boolean aExist = false;
            boolean bExist = false;
            for (char ch : pChars) {
                if (ch == 'a') {
                    aExist = true;
                } else {
                    bExist = true;
                }
                if (aExist && bExist) {
                    return false;
                }
            }
        }


        int countA = 0;
        int countB = 0;
        for (char ch : pChars) {
            if (ch == 'a') {
                countA++;
            } else {
                countB++;
            }
        }
        int vLen = vChars.length;

        if (countA * countB == 0) {
            int count = countA + countB;
            if (vLen % count != 0) {
                return false;
            } else {
                int len = vLen / count;
                for (int i = len; i < vLen; i += len) {
                    if (!stringEquals(vChars, 0, i, len)) {
                        return false;
                    }
                }
                return true;
            }
        }

        for (int i = 0; i <= vLen; i++) {
            if (vLen - countA * i < 0) {
                break;
            }
            int bLen = (vLen - countA * i) / countB;
            if ((bLen * countB == vLen - i * countA)) {
                int index = 0;
                int[] ab = new int[2];
                Arrays.fill(ab, -1);
                boolean notMatch = false;
                for (char ch : pChars) {
                    if (ch == 'a') {
                        if (ab[0] == -1) {
                            ab[0] = index;
                        } else {
                            if (!stringEquals(vChars, ab[0], index, i)) {
                                notMatch = true;
                                break;
                            }
                        }
                        index += i;
                    } else {
                        if (ab[1] == -1) {
                            ab[1] = index;
                        } else {
                            if (!stringEquals(vChars, ab[1], index, bLen)) {
                                notMatch = true;
                                break;
                            }
                        }
                        index += bLen;
                    }
                    if (bLen == i) {
                        if (ab[0] != -1 && ab[1] != -1) {
                            if (stringEquals(vChars, ab[0], ab[1], bLen)) {
                                notMatch = true;
                                break;
                            }
                        }
                    }
                }
                if (!notMatch) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean stringEquals(char[] chars, int i, int j, int len) {
        for (int k = 0; k < len; k++) {
            if (chars[i + k] != chars[j + k]) {
                return false;
            }
        }
        return true;
    }
}