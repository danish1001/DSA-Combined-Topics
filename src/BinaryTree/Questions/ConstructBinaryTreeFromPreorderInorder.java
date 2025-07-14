package BinaryTree.Questions;

import BinaryTree.TreeNode;
import java.util.*;

public class ConstructBinaryTreeFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        int n = preorder.length;
        for(int i=0; i<n; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n-1, inorder, 0, n-1, inMap);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int mid = map.get(preorder[preStart]);
        int size = mid - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + size,
                inorder, inStart, mid-1, map);

        root.right = buildTree(preorder, preStart + size + 1, preEnd,
                inorder, mid+1, inEnd, map);
        return root;
    }
}
