import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// Very slow! Runtime only beats 7.71% of java submissions.
// But original!

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cand = Arrays.stream(candidates).boxed().collect(Collectors.toList());
        return cs(cand, target);
    }

    private List<List<Integer>> cs(List<Integer> candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(target <= 0){
            return ans;
        }
        for(Integer cand: candidates){
            if(target == cand.intValue()){
                temp.clear();
                temp.add(cand);
                ans.add(temp);
            }
        }
        // System.out.println("Candidates: " + candidates);
        // System.out.println("Target: " + target);
        // System.out.println("Answer: " + ans);
        int l = candidates.size();
        for(int i=0; i<l; i++){
            for(List<Integer> subans: cs(candidates.subList(i, l), target - candidates.get(i))){
                // System.out.println("Answer: " + ans);
                // System.out.println("Subanswer: " + subans);
                // temp.clear();
                // ATTENTION: temp cannot be modified and added to ans, because that would change its content.
                Integer[] t = new Integer[subans.size() + 1];
                t[0] = candidates.get(i);
                int index = 1;
                for(Integer j: subans){
                    t[index] = j;
                    index ++;
                    // System.out.println("Temp answer: " + temp);
                }
                ans.add(Arrays.asList(t));
                // System.out.println("Answer: " + ans);
            }
        }
        // System.out.println("------");
        return ans;
    }
}

// @lc code=end

