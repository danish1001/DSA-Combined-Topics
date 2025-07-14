package BinarySearchTree.Questions;

import BinaryTree.TreeNode;

public class InorderPredecessorAndSuccessor {
    public static void findPreSuc(TreeNode root, TreeNode[] pre, TreeNode[] suc, int key) {
        TreeNode curr = root;
        while(curr != null) {
            if(curr.data < key) {
                pre[0] = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        curr = root;
        while(curr != null) {
            if(curr.data > key) {
                suc[0] = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

    }
}
