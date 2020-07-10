import java.util.*;

/**
 * @author tostw
 * 面试题 17.13. 恢复空格
 */
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx : trie.search(sentence, i - 1)) {
                dp[i] = Math.min(dp[i], dp[idx]);
            }
        }

        return dp[n];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }

    public List<Integer> search(String sentence, int endPos) {
        List<Integer> indices = new ArrayList<>();
        TrieNode cur = root;
        for (int i = endPos; i >= 0; i--) {
            int c = sentence.charAt(i) - 'a';
            if (cur.children[c] == null) {
                break;
            }
            cur = cur.children[c];
            if (cur.isWord) {
                indices.add(i);
            }
        }
        return indices;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }
}