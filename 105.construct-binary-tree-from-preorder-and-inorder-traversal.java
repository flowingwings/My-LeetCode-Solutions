import java.util.Arrays;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.*/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if(n==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int sep = -1;
        for(int i=0; i<n; i++){
            if(inorder[i] == preorder[0]){
                sep = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, sep+1), Arrays.copyOfRange(inorder, 0, sep));
        root.right = buildTree(Arrays.copyOfRange(preorder, sep+1, n), Arrays.copyOfRange(inorder, sep+1, n));
        return root;
    }
}
// @lc code=end

