import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                st.push(new Character(c));
            }
            else{
                if(st.empty()){
                    return false;
                }
                if((c == ')' && st.peek() == '(') || (c==']' && st.peek()=='[') || (c=='}' && st.peek()=='{')){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(!st.empty()){
            return false;
        }
        return true;
    }
}
// @lc code=end

