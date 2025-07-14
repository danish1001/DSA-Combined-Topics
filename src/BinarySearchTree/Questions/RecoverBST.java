package BinarySearchTree.Questions;

import BinaryTree.TreeNode;

public class RecoverBST {
    // swap two nodes to make a valid BST
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        inorder(root);

        if(first != null && middle != null && last == null) {
            int data = first.data;
            first.data = middle.data;
            middle.data = data;
        } else if(first != null && last != null) {
            int data = first.data;
            first.data = last.data;
            last.data = data;
        }
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);

        if(prev != null && root.data < prev.data) {
            if(first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
