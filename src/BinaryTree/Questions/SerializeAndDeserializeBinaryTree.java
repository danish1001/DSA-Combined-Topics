package BinaryTree.Questions;

import BinaryTree.TreeNode;
import java.util.*;
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.data + " ");
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) {
                sb.append(node.left.data + " ");
                q.add(node.left);
            } else {
                sb.append("N ");
            }
            if(node.right != null) {
                sb.append(node.right.data + " ");
                q.add(node.right);
            } else {
                sb.append("N ");
            }
        }
        return (sb.toString()).trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] arr = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1, n = arr.length;

        while(i < n) {
            TreeNode node = q.poll();
            if(!arr[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.left);
            }
            i++;
            if(i == n) break;
            if(!arr[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
}
