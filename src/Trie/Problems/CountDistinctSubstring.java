package Trie.Problems;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubstring {
    // count distinct substring is different from count distinct subsequence
    // count distinct substring != count distinct subsequence

    public static int countDistinctSubstrings_sol1(String s) {
        TrieNode root = new TrieNode();
        int count = 1;

        for(int i=0; i<s.length(); i++) {
            TrieNode curr = root;
            for(int j=i; j<s.length(); j++) {
                char ch = s.charAt(j);
                if(!curr.contains(ch)) {
                    count++;
                    curr.insert(ch);
                }
                curr = curr.next(ch);
            }
        }
        return count;
    }
    private static class TrieNode {
        private TrieNode[] links;
        public TrieNode() {
            this.links = new TrieNode[26];
        }
        public void insert(char ch) {
            this.links[ch-'a'] = new TrieNode();
        }
        public boolean contains(char ch) {
            return this.links[ch-'a'] == null ? false : true;
        }
        public TrieNode next(char ch) {
            return this.links[ch-'a'];
        }
    }

    // --------------------------------------------------------------------------------------------------

    public static int countDistinctSubstrings_sol2(String s) {
        Set<String> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<s.length(); j++) {
                sb.append(s.charAt(j));
                String str = sb.toString();
                set.add(str);

            }
        }
        return set.size() + 1;
    }
}
