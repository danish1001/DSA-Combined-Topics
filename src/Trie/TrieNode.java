package Trie;


public class TrieNode {
    private TrieNode[] links;
    private boolean flag;
    public TrieNode() {
        this.links = new TrieNode[26];
        this.flag = false;
    }
    public boolean isEnd() {
        if (flag) return true;
        return false;
    }
    public void setEnd() {
        this.flag = true;
    }
    public void insert(char ch) {
        this.links[ch - 'a'] = new TrieNode();
    }
    public TrieNode getNode(char ch) {
        return this.links[ch - 'a'];
    }
    public boolean containsKey(char ch) {
        if (this.links[ch - 'a'] == null) return false;
        return true;
    }
}
