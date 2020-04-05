import java.util.Arrays;

/**
 * @author tostw
 * No.945 使数组唯一的最小增量
 * <p>
 * 方法二，先排序，然后调整成依次+1的数组
 */
public class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A == null) {
            return -1;
        }
        int times = 0;
        int[] a = new int[100];
        for (int i : A) {
            while (i > a.length || i * 2 >= a.length) {
                a = Arrays.copyOf(a, (i + 1) * 2);
            }
            a[i]++;
        }
        for (int i = 0, len = a.length; i < len; i++) {
            if (a[i] > 1 && i != a.length - 1) {
                a[i + 1] += (a[i] - 1);
                times += (a[i] - 1);
                a[i] = 1;
            }
        }
        return times;
    }


    public static void main(String[] args) {
//        int[] a = new int[]{37, 19, 20, 13, 26, 36, 34, 23, 2, 46, 20, 19, 0, 6, 43, 25, 36, 7, 16, 42, 41, 12, 1, 40, 8, 39, 34, 8, 3, 46, 29, 31, 22, 7, 30, 12, 40, 36, 1, 46, 1, 4, 14, 7, 11, 17, 36, 20, 13, 24};
//        int[] a = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] a = new int[]{2, 3, 3, 5, 5, 5, 5, 3, 2, 4};
        System.out.println(new Solution().minIncrementForUnique(a));
    }
}
