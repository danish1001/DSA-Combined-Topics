package Trie.Problems;
//1707. Maximum XOR With an Element From Array
//        Solved
//        Hard
//        Topics
//        Companies
//        Hint
//        You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].
//
//        The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.
//
//        Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.
//
//
//
//        Example 1:
//
//        Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
//        Output: [3,3,7]
//        Explanation:
//        1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
//        2) 1 XOR 2 = 3.
//        3) 5 XOR 2 = 7.
//        Example 2:
//
//        Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
//        Output: [15,-1,5]
//
//
//        Constraints:
//
//        1 <= nums.length, queries.length <= 105
//        queries[i].length == 2
//        0 <= nums[j], xi, mi <= 109

public class MaximumXORWithAnElementFromArray {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        for(int i=0; i<nums.length; i++) {
            trie.insert(nums[i]);
        }
        int[] queryRes = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            queryRes[i] = trie.getMaxXor(queries[i][0], queries[i][1]);
        }
        return queryRes;
    }
    private class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }
        public void insert(int num) {
            TrieNode curr = root;
            for(int i=31; i>=0; i--) {
                int bit = getBit(num, i);
                curr.insert(bit, num);
                curr = curr.next(bit);
            }
        }
        private int getMaxXor(int num, int maxRange) {
            int newNumber = 0;
            TrieNode curr = root;
            for(int i=31; i>=0; i--) {
                int bit = getBit(num, i);
                int flippedBit = flip(bit);

                if(curr.contains(flippedBit) && curr.getMin(flippedBit) <= maxRange) {
                    if(flippedBit == 1) newNumber = newNumber | (1 << i);
                    curr = curr.next(flippedBit);
                } else if(curr.getMin(bit) <= maxRange) {
                    if(bit == 1) newNumber = newNumber | (1 << i);
                    curr = curr.next(bit);
                } else {
                    return -1;
                }
            }
            return newNumber ^ num;
        }
        private int getBit(int ele, int i) {
            return (ele & (1 << i)) == 0 ? 0 : 1;
        }
        private int flip(int bit) {
            return bit == 1 ? 0 : 1;
        }
    }
    private class TrieNode {
        private TrieNode[] links;
        private int min;

        public TrieNode() {
            this.links = new TrieNode[2];
            this.min = Integer.MAX_VALUE;
        }
        public void insert(int bit, int num) {
            if(!contains(bit)) this.links[bit] = new TrieNode();
            this.links[bit].min = Math.min(num, this.links[bit].min);
        }
        public TrieNode next(int bit) {
            return this.links[bit];
        }
        public boolean contains(int bit) {
            return (this.links[bit] == null) ? false : true;
        }
        public int getMin(int bit) {
            return this.links[bit].min;
        }
    }
}
