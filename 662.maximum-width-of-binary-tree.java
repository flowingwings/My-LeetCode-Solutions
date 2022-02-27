import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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

// COPY STARTS
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }
}

class AnnotatedNode {
    TreeNode node;
    int depth, pos;
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}
// COPY ENDS

class FailedSolution {
    // When the tree has too many levels, 
    // this solution got a TLE.
    static int NULL_VALUE = 101;
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        // TreeNode temp = root;
        List<TreeNode> l1 = new ArrayList<>();
        l1.add(root);
        List<TreeNode> l2 = new ArrayList<>();
        while(!l1.isEmpty()){
            // for(TreeNode n: l1){
            //     System.out.println(n.val);
            // }
            // System.out.println("------");
            // ATTENTION:
            // The variable i here CANNOT increase after each loop!!!
            // for(int i=0; i<l1.size(); ){
            //     if(l1.get(i).val!=NULL_VALUE){
            //         break;
            //     }
            //     // System.out.println("index: "+i+", val: "+l1.get(i).val);
            //     l1.remove(i);
            // }
            while(!l1.isEmpty() && l1.get(0).val == NULL_VALUE){
                l1.remove(0);
            }
            for(int i=l1.size()-1; i>=0; i--){
                if(l1.get(i).val!=NULL_VALUE){
                    break;
                }
                // System.out.println("index: "+i+", val: "+l1.get(i).val);
                l1.remove(i);
            }
            // System.out.println("---");
            for(TreeNode node: l1){
                if(node.left==null || node.left.val==NULL_VALUE){
                    l2.add(new TreeNode(NULL_VALUE, null, null));
                }
                else{
                    l2.add(node.left);
                }
                if(node.right==null || node.right.val==NULL_VALUE){
                    l2.add(new TreeNode(NULL_VALUE, null, null));
                }
                else{
                    l2.add(node.right);
                }
            }
            ans=Math.max(ans, l1.size());
            int i1=0;
            // for(TreeNode n: l1){
            //     System.out.println("index: "+(i1++)+", val: "+n.val);
            // }
            // System.out.println("===");
            l1.clear();
            // int tempStartIndex=0, tempEndIndex=0;
            for(TreeNode node: l2){
                l1.add(node);
            }
            l2.clear();
        }
        return ans;
    }
}
// @lc code=end

