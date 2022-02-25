import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            if(nums[i] > 0 ){
                break;
            }
            if(i==0 || nums[i] != nums[i-1]){
                int lo = i+1, hi = nums.length-1, sum = 0-nums[i];
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo ++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi --;
                        lo ++;
                        hi --;
                    }
                    else if(nums[lo] + nums[hi] < sum) lo ++;
                    else hi --;
                }
            }
        }
        return ans;
    }
}
