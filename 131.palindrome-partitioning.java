import java.util.*;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    void debug(String s1, String s2){
        System.out.println(s1+": "+s2);
    }
    boolean isPalindrome(String s){
        int l = s.length();
        for(int i=0; i<l/2; i++){
            if(s.charAt(i) != s.charAt(l-i-1)){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<String> temp = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        // if(n==0){
        //     temp.add("");
        //     ans.add(temp);
        //     return ans;
        // }
        for(int i=1; i<=n; i++){
            String curSub = s.substring(0, i);
            debug("i", Integer.toString(i));
            debug("curSub", curSub);
            if(isPalindrome(curSub)){
                if(i==n){
                    temp.clear();
                    temp.add(new String(curSub));
                    ans.add(new ArrayList<String>(temp));
                    break;
                }
                for(List<String> ls: partition(s.substring(i))){
                    debug("ls", ls.toString());
                    temp.clear();
                    temp.add(new String(curSub));
                    temp.addAll(ls);
                    ans.add(new ArrayList<String>(temp));
                }
            }
        }
        return ans;
    }
}
// @lc code=end

