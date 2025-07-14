package Trie;

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                node.insert(ch);
            }
            node = node.getNode(ch);
        }
        node.setEnd();
    }
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                return false;
            }
            node = node.getNode(ch);
        }
        return node.isEnd();
    }
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch)) {
                return false;
            }
            node = node.getNode(ch);
        }
        return true;
    }
}
