import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tostw
 * No.39 组合总数
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    private void backtrace(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            backtrace(candidates, target, res, list, i, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        List<List<Integer>> res = new Solution().combinationSum(candidates, 8);
        for (List<Integer> list : res) {
            list.forEach(System.out::print);
            System.out.println();
        }
    }
}