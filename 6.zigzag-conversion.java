/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder ans = new StringBuilder();
        int n = numRows;
        int l = s.length();
        if(n==1){
            return s;
        }
        for(int i=0; 2*i*(n-1)<l; i++){
            ans.append(s.charAt(2*i*(n-1)));
            // System.out.println(s.charAt(2*i*(n-1)));
        }
        for(int i=n-2; i>0; i--){
            for(int j=1; ; j++){
                if((2*j-1)*(n-1)-i<l){
                    // System.out.println("i: "+i+", j="+j);
                    // System.out.println(s.charAt((2*j-1)*(n-1)-i));
                    ans.append(s.charAt((2*j-1)*(n-1)-i));
                }
                else{
                    break;
                }
                if((2*j-1)*(n-1)+i<l){
                    // System.out.println("i: "+i+", j="+j);
                    // System.out.println(s.charAt((2*j-1)*(n-1)+i));
                    ans.append(s.charAt((2*j-1)*(n-1)+i));
                }
                else{
                    break;
                }
            }
        }
        if(n>1){
            for(int j=1; (2*j-1)*(n-1)<l; j++){
                ans.append(s.charAt((2*j-1)*(n-1)));
            }
        }
        return ans.toString();
    }
}
// @lc code=end

