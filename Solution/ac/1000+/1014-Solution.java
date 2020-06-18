import java.util.*;

/**
 * @author tostw
 * No.1014 最佳观光组合
 */

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0;
        int currScore = A[0];

        for (int i = 1, len = A.length; i < len; i++) {
            maxScore = Math.max(maxScore, currScore + A[i] - i);
            currScore = Math.max(currScore, A[i] + i);
        }
        return maxScore;
    }
}