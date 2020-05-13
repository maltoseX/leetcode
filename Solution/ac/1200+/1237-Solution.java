import java.util.ArrayList;
import java.util.List;

/**
 * @author tostw
 * No.1237 找出给定方程的正整数解
 */
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; customfunction.f(i, 1) <= z; i++) {
            for (int j = 1; customfunction.f(i, j) <= z; j++) {
                if (customfunction.f(i, j) == z) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
}

interface CustomFunction {
    int f(int x, int y);
}

