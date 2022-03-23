import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
    public List<TreeNode> generateTrees(int n) {
        // List<TreeNode> ans = new ArrayList<>();
        // TreeNode temp;
        // for(int i=1; i<=n; i++){
        //     temp = new TreeNode(i);
        //     temp.left = helper(1, i-1);
        //     temp.right = helper(i+1, n);
        // }
        // return ans;
        return helper(1, n);
    }
    List<TreeNode> helper(int start, int end){
        List<TreeNode> ans = new ArrayList<>();
        if(start > end){
            ans.add(null);
            return ans;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> leftTrees = helper(start, i-1);
            List<TreeNode> rightTrees = helper(i+1, end);
            for(TreeNode lt: leftTrees){
                for(TreeNode rt: rightTrees){
                    TreeNode curr = new TreeNode(i, lt, rt);
                    ans.add(curr);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

