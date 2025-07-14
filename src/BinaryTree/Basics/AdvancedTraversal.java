package BinaryTree.Basics;
import BinaryTree.TreeNode;

import java.util.*;

public class AdvancedTraversal {
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int n = q.size();
            while(n != 0) {
                TreeNode node = q.poll();
                levelList.add(node.data);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                n--;
            }
            res.add(levelList);
        }
        return res;
    }

    // Zig-Zag Traversal using Stack
    public static List<List<Integer>> zigZagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> parentStack =  new Stack<>();
        Stack<TreeNode> childStack = new Stack<>();
        boolean flag = true;
        parentStack.add(root);

        while (!parentStack.isEmpty()) {
            int n = parentStack.size();
            List<Integer> list = new ArrayList<>();
            if(flag) {
                for(int i=0; i<n; i++) {
                    TreeNode node = parentStack.pop();
                    list.add(node.data);
                    if(node.left != null) childStack.add(node.left);
                    if(node.right != null) childStack.add(node.right);
                }
                flag = false;
            } else {
                for(int i=0; i<n; i++) {
                    TreeNode node = parentStack.pop();
                    list.add(node.data);
                    if(node.right != null) childStack.add(node.right);
                    if(node.left != null) childStack.add(node.left);
                }
                flag = true;
            }
            res.add(list);
            parentStack = childStack;
            childStack = new Stack<>();
        }
        return res;
    }

    // Diagonal Traversal
    public List<Integer> diagonal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            while (node != null) {
                res.add(node.data);
                if (node.left != null) q.add(node.left);
                node = node.right;
            }
        }
        return res;
    }

    // Morris Traversals -----------------------------------------------------------------------------------------------
    public List<Integer> iterativePreOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null) {
            TreeNode left = curr.left;

            if(left == null) {
                res.add(curr.data);
                curr = curr.right;
            } else {
                TreeNode right = findRight(left, curr);

                if(right.right == null) {
                    right.right = curr;
                    res.add(curr.data);
                    curr = curr.left;
                } else {
                    right.right = null;
                    // res.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return res;
    }

    public List<Integer> iterativeIinOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null) {
            TreeNode left = curr.left;

            if(left == null) {
                res.add(curr.data);
                curr = curr.right;
            } else {
                TreeNode right = findRight(left, curr);

                if(right.right == null) {
                    right.right = curr;
                    curr = curr.left;
                } else {
                    right.right = null;
                    res.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return res;
    }
    private TreeNode findRight(TreeNode left, TreeNode curr) {
        while(left.right != null && left.right != curr) {
            left = left.right;
        }
        return left;
    }


    public List<Integer> iterativePostOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null) {
            TreeNode left = curr.right;

            if(left == null) {
                res.add(curr.data);
                curr = curr.left;
            } else {
                TreeNode right = findRightPostOrder(left, curr);

                if(right.left == null) {
                    right.left = curr;
                    res.add(curr.data);
                    curr = curr.right;
                } else {
                    right.left = null;
                    // res.add(curr.val);
                    curr = curr.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
    private TreeNode findRightPostOrder(TreeNode left, TreeNode curr) {
        while(left.left != null && left.left != curr) {
            left = left.left;
        }
        return left;
    }



}
