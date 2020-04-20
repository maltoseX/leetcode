import java.util.*;

/**
 * @author tostw
 * No.49 字母异位词分组
 */
public class Solution {
    // 自己写的
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<int[], List<String>> map = new HashMap<>(10);
//        List<List<String>> result = new ArrayList<>();
//        int[] chars;
//        Map.Entry<int[], List<String>> entry;
//        for (String str : strs) {
//            chars = getCharsArr(str);
//            entry = getEntry(map, chars);
//            if (entry == null) {
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                result.add(list);
//                map.put(chars, list);
//            } else {
//                List<String> list = entry.getValue();
//                list.add(str);
//            }
//        }
//        return result;
//    }
//
//    private int[] getCharsArr(String str) {
//        int[] tempChars = new int[26];
//        for (int i = 0, len = str.length(); i < len; i++) {
//            tempChars[str.charAt(i) - 'a']++;
//        }
//        return tempChars;
//    }
//
//    private Map.Entry<int[], List<String>> getEntry(Map<int[], List<String>> map, int[] target) {
//        for (Map.Entry<int[], List<String>> entry : map.entrySet()) {
//            if (Arrays.equals(entry.getKey(), target)) {
//                return entry;
//            }
//        }
//        return null;
//    }

    // 官方题解
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(str);
        }

        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}