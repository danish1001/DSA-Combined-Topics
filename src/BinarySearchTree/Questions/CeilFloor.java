package BinarySearchTree.Questions;

import BinaryTree.TreeNode;

public class CeilFloor {
    int findCeil(TreeNode root, int key) {
        if (root == null) return -1;
        int res = -1;
        while(root != null) {
            if(root.data == key) {
                return key;
            } else if(root.data < key) {
                root = root.right;
            } else {
                res = root.data;
                root = root.left;
            }
        }
        return res;
    }
    public static int floor(TreeNode root, int x) {
        int res = -1;
        while(root != null) {
            if(root.data == x) {
                return x;
            } else if(root.data < x) {
                res = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }
}
