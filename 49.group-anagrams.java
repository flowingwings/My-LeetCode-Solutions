import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

// Uses the appearing times again...
// Why do I always forget this?
// I should have been able to come up with this algorithm.
// Am I too lazy to think carefully,
// considering I turned to the solution soon after finishing reading the problem.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList<>();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for(String str: strs){
            Arrays.fill(count, 0);
            for(char c: str.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i: count){
                sb.append("#");
                sb.append(Integer.toString(i));
            }
            String key = sb.toString();
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }
}
// @lc code=end

