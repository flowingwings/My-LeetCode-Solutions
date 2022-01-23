
class solute{
    public static void main(String[] agrs) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0){
            return 0;
        }
        int ans = 1;
        int len = s.length();
        int[] maxl = new int[len];
        for(int i=0; i<len; i++){
            maxl[i] = 1;
        }
        for(int i=1; i<len; i++){
            for(int j=i-1; j>=i-maxl[i-1]; j--){
                String subs = s.substring(j, i);
                char curr = s.charAt(i);
                if(subs.indexOf(Character.toString(curr)) == -1){
                    maxl[i] = i - j + 1;
                }
                else{
                    break;
                }
            }
            if(ans < maxl[i]){
                ans = maxl[i];
            }
        }
        return ans;
    }
}
