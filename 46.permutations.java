import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for(int i: nums){
            numsList.add(new Integer(i));
        }
        return recur(numsList);
    }

    public List<List<Integer>> recur(List<Integer> numsList){
        List<List<Integer>> ans = new ArrayList<>();

        System.out.println("NumsList now:");
        System.out.println(numsList);

        if(numsList.size() == 1){
            // WARNING: ALWAYS USE COPY!
            // ans.add(numsList);
            List<Integer> tempAns = new ArrayList<>();
            tempAns.add(numsList.get(0));
            ans.add(tempAns);
            System.out.println("NumsList now?");
            System.out.println(numsList);
            return ans;
        }
        for(int i=0; i<numsList.size(); i++){
            Integer temp = numsList.get(i);

            System.out.println("Before remove:");
            System.out.println(numsList);

            numsList.remove(i);

            System.out.println("After remove "+temp+" at index "+i+":");
            System.out.println(numsList);

            for(List<Integer> tempList: recur(numsList)){
                System.out.println("TempList:");
                System.out.println(tempList);
                tempList.add(temp);
                ans.add(tempList);
                System.out.println("NumsList after tempList:");
                System.out.println(numsList);
            }
            numsList.add(i, temp);

            System.out.println("After recover "+temp+" at index "+i+":");
            System.out.println(numsList);

        }
        return ans;
    }
}
// @lc code=end

