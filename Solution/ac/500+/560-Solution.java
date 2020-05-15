import java.util.HashMap;
import java.util.Map;

/**
 * @author tostw
 * No.560 和为K的子数组
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int prev = 0;

        for (int i = 0, len = nums.length; i < len; i++) {
            prev += nums[i];
            if (map.containsKey(prev - k)) {
                res += map.get(prev - k);
            }
            map.put(prev, map.getOrDefault(prev, 0) + 1);
        }
        return res;
    }
}

