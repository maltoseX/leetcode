import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tostw
 * No.56 合并区间
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > result[index][1]) {
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }

        return Arrays.copyOf(result, index + 1);
    }
}