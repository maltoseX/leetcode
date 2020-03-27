import java.util.HashMap;
import java.util.Map;

/**
 * @author tostw
 * No.914 卡牌分组
 */
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int z = (Integer) map.values().toArray()[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            z = gcd(z, value);
        }
        return z >= 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,2,2,2,3,3};
        System.out.println(new Solution().hasGroupsSizeX(a));
    }
}

