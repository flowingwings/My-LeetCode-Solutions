/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for(int i=0; i<s.length(); i++){
            num[s.charAt(i)-'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!vis[c-'a']){
                while(sb.length()>0 && sb.charAt(sb.length()-1)>c){
                    if(num[sb.charAt(sb.length()-1)-'a']>0){
                        vis[sb.charAt(sb.length()-1)-'a'] = false;
                        sb.deleteCharAt(sb.length()-1);
                    }
                    else{
                        break;
                    }
                }
                vis[c-'a']=true;
                sb.append(c);
            }
            num[c-'a']--;
        }
        return sb.toString();
    }
}
// @lc code=end

