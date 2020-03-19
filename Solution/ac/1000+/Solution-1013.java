import java.util.Arrays;

/**
 * @author tostw
 * No.1013 将数组分成和相等的三个部分
 */
public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 == 0) {
            int result = sum / 3;
            int left = 0, right = A.length - 1;
            int leftSum = A[left];
            int rightSum = A[right];
            while (left + 1 < right) {
                if (leftSum == result && rightSum == result) {
                    return true;
                }
                if (leftSum != result) {
                    leftSum += A[++left];
                }
                if (rightSum != result) {
                    rightSum += A[--right];
                }
            }
        }
        return false;
    }
}
