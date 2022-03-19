/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
 */

// @lc code=start

  //Definition for a binary tree node.
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
    public String tree2str(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            return sb.toString();
        }
        if(root.left == null){
            sb.append("()");
        }
        else{
            sb.append("("+tree2str(root.left)+")");
        }
        if(root.right == null){
            // do nothing
        }
        else{
            sb.append("("+tree2str(root.right)+")");
        }
        return sb.toString();
    }
}
// @lc code=end

