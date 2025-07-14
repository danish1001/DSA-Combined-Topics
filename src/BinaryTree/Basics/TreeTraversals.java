package BinaryTree.Basics;
import BinaryTree.TreeNode;

import java.util.*;

public class TreeTraversals {

    // Recursive Traversals --------------------------------------------------------------------------------------------
    public static void inOrder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        inOrder(root.left, res);
        res.add(root.data);
        inOrder(root.right, res);
    }

    public static void preOrder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.data);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    public static void postOrder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.data);
    }


    // Iterative Traversals Using Stack --------------------------------------------------------------------------------
    public List<Integer> preOrderUsingStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.data);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return res;
    }

    public List<Integer> inOrderUsingStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        while(true) {
            if(root != null) {
                stack.add(root);
                root = root.left;
            } else {
                if(stack.isEmpty()) break;
                root = stack.pop();
                res.add(root.data);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> postOrderUsingStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.data);
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
        }
        Collections.reverse(res);
        return res;
    }


}
