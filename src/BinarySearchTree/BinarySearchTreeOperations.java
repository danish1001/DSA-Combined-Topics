package BinarySearchTree;

import BinaryTree.TreeNode;

public class BinarySearchTreeOperations {

    // Insert Node in BST
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.data < val) root.right = insertIntoBST(root.right, val);
        else if(root.data > val) root.left = insertIntoBST(root.left, val);
        return root;
    }

    // Delete Node in BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.data == key) return delete(root);
        TreeNode node = root;
        while(root != null) {
            if(root.left != null && root.left.data == key) {
                root.left = delete(root.left);
            } else if(root.right != null && root.right.data == key) {
                root.right = delete(root.right);
            } else if(root.data > key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return node;
    }

    private TreeNode delete(TreeNode root) {
        TreeNode right = root.right;
        if(right == null) return root.left;
        TreeNode rightleft = findLeft(right);
        rightleft.left = root.left;
        return right;
    }

    private TreeNode findLeft(TreeNode node) {
        while(node.left != null) node = node.left;
        return node;
    }

    private boolean isLeaf(TreeNode root) {
        if(root != null && root.left == null && root.right == null) return true;
        return false;
    }
}
