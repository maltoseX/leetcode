/**
 * @author tostw
 * No.820 单词的压缩编码
 * (字典树)
 */
public class Solution {
    public int minimumLengthEncoding(String[] words) {

        class TrieNode {

            TrieNode[] children;
            int count;
            boolean isLeaf;

            TrieNode() {
                children = new TrieNode[26];
                count = 0;
                isLeaf = false;
            }

            public void insert(TrieNode root, String word) {
                TrieNode p = root;
                boolean flag = false;
                for (int i = word.length() - 1; i >= 0; i--) {
                    char ch = word.charAt(i);
                    int k = ch - 'a';
                    if (p.isLeaf && i < word.length() - 1) {
                        count -= (word.length() - 1 - i) + 1;
                        p.isLeaf = false;
                    }
                    if (p.children[k] == null) {
                        p.children[k] = new TrieNode();
                        flag = true;
                    }
                    p = p.children[k];
                }
                if (flag) {
                    count += word.length() + 1;
                    p.isLeaf = true;
                }
            }
        }

        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(root, word);
        }

        return root.count;
    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "time", "me", "bell"
        };
        int result = new Solution().minimumLengthEncoding(words);
        System.out.println(result);
    }
}

