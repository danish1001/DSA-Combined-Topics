package BinarySearchTree.Questions;

import BinaryTree.TreeNode;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;
        if(root.data < p.data && root.data < q.data) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(root.data > p.data && root.data > q.data) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

}
