import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> stringMulti(List<String> l1, String s2){
        List<String> ans = new ArrayList<>();
        for(String s1: l1){
            for(char c2: s2.toCharArray()){
                ans.add(s1 + Character.toString(c2));
            }
        }
        return ans;
    }
    public List<String> letterCombinations(String digits) {
        String[] buttons = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        int len = digits.length();
        if(len == 0){
            return ans;
        }
        for(char c: buttons[digits.charAt(0) - '2'].toCharArray()){
            ans.add(Character.toString(c));
        }
        for(int i=1; i < len; i++){
            ans = stringMulti(ans, buttons[digits.charAt(i) - '2']);
        }
        return ans;
    }
}