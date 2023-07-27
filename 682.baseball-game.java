import java.util.Stack;

/*
 * @lc app=leetcode id=682 lang=java
 *
 * [682] Baseball Game
 */

// @lc code=start
class Solution {
    static int sum;
    Stack<Integer> stack = new Stack<>();
    public int calPoints(String[] ops) {
        sum = 0;
        for(String op: ops){
            if(op.equals("+")){
                int score1 = stack.pop();
                int score2 = stack.peek();
                sum += score1+score2;
                stack.push(score1);
                stack.push(score1+score2);
            }
            else if(op.equals("D")){
                int score = stack.peek();
                sum += 2*score;
                stack.push(2*score);
            }
            else if(op.equals("C")){
                int score = stack.pop();
                sum -= score;
            }
            else{
                int score = Integer.parseInt(op);
                stack.push(score);
                sum += score;
            }
        }
        return sum;
    }
}
// @lc code=end

