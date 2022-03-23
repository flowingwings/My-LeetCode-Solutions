import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length==0){
            List<Integer> temp = new ArrayList<>();
            ans.add(temp);
            return ans;
        }
        int i0 = nums[0];
        List<List<Integer>> lastAns = subsets(Arrays.copyOfRange(nums, 1, nums.length));
        for(int i=0; i<lastAns.size(); i++){
            List<Integer> a = lastAns.get(i);
            ans.add(new ArrayList<Integer>(a));
            a.add(0, i0);
            ans.add(new ArrayList<Integer>(a));
        }
        System.out.println("NUMS: "+Arrays.toString(nums));
        System.out.println("ANS: "+ans.toString());
        return ans;
    }
}
// @lc code=end

