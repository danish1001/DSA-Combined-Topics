package BinaryTree.Questions;

import BinaryTree.TreeNode;
import java.util.*;
public class ConstructBinaryTreeFromPostorderInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, n-1, postorder, 0, n-1, map);
    }
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int mid = map.get(postorder[postEnd]);
        int size = mid - inStart;

        root.left = buildTree(inorder, inStart, mid-1,
                postorder, postStart, postStart+size-1, map);

        root.right = buildTree(inorder, mid+1, inEnd,
                postorder, postStart+size, postEnd-1, map);

        return root;
    }
}
