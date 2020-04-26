/**
 * @author tostw
 * No.859 亲密字符串
 */
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            int[] a = new int[26];
            for (int i = 0, len = A.length(); i < len; i++) {
                int index = A.charAt(i) - 'a';
                a[index]++;
                if (a[index] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0, len = A.length(); i < len; i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return (A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
        }
    }

    public static void main(String[] args) {
        String A = "aa";
        String B = "aa";
        System.out.println(new Solution().buddyStrings(A, B));
    }
}