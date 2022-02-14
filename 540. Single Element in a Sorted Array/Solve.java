public class Solve {
    
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Not the fastest algorithm.
        int result = 0;
        for(int num: nums){
            result ^= num;
        }
        return result;
    }
}