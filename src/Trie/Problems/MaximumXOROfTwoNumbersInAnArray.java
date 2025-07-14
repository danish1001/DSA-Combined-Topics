package Trie.Problems;
//421. Maximum XOR of Two Numbers in an Array
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
//
//
//
//        Example 1:
//
//        Input: nums = [3,10,5,25,2,8]
//        Output: 28
//        Explanation: The maximum result is 5 XOR 25 = 28.
//        Example 2:
//
//        Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//        Output: 127
//
//
//        Constraints:
//
//        1 <= nums.length <= 2 * 105
//        0 <= nums[i] <= 231 - 1
public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i=0; i<nums.length; i++) {
            trie.add(nums[i]);
        }
        int maxXor = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            int xor = trie.getMaxXor(nums[i]);
            maxXor = Math.max(maxXor, xor);
        }
        return maxXor;
    }
    public class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void add(int num) {
            TrieNode curr = root;
            for(int i=31; i>=0; i--) {
                int bit = ((num >> i) & 1);
                if(!curr.contains(bit)) curr.insert(bit);
                curr = curr.next(bit);
            }
        }
        public int getMaxXor(int num) {
            TrieNode curr = root;
            int newNumber = 0;
            for(int i=31; i>=0; i--) {
                int bit = ((num >> i) & 1);
                int flipped = (bit == 0 ? 1 : 0);

                if(curr.contains(flipped)) {
                    curr = curr.next(flipped);
                    if(flipped == 1) newNumber = newNumber | (1 << i);
                } else {
                    curr = curr.next(bit);
                    if(bit == 1) newNumber = newNumber | (1 << i);
                }
            }
            return newNumber ^ num;
        }
    }
    private class TrieNode {
        TrieNode[] links;
        public TrieNode() {
            links = new TrieNode[2];
        }
        public TrieNode next(int bit) {
            return this.links[bit];
        }
        public void insert(int bit) {
            this.links[bit] = new TrieNode();
        }
        public boolean contains(int bit) {
            return (this.links[bit] == null ? false : true);
        }
    }
}
