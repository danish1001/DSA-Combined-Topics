package BinarySearchTree.Questions;

import BinaryTree.TreeNode;

public class BSTfromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(preorder, new int[1], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode constructTree(int[] preorder, int[] index, int min, int max) {
        if(index[0] >= preorder.length || preorder[index[0]] <= min || preorder[index[0]] >= max) return null;
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left = constructTree(preorder, index, min, root.data);
        if(index[0] < preorder.length) root.right = constructTree(preorder, index, root.data, max);
        return root;
    }
}
