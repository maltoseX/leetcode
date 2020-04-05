//
///**
// * @author tostw
// * 面试题 01.07 旋转矩阵
// */
//public class Solution {
//    public void rotate(int[][] matrix) {
//
//    }
//}


/**
 * @author tostw
 * No.169 多数元素
 * <p>
 * Boyer-Moore 投票算法 (求众数)
 * Boyer-Moore 算法的本质和方法四中的分治十分类似。我们首先给出 Boyer-Moore 算法的详细步骤：
 * 1)我们维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
 * 2)我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
 * · 如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
 * · 如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
 * 3)在遍历完成后，candidate 即为整个数组的众数。
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(a));
    }
}