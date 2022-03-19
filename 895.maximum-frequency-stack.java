import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */

// @lc code=start
class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0);
        f += 1;
        freq.put(val, f);
        if(f > maxFreq){
            maxFreq = f;
        }
        group.computeIfAbsent(f, key -> new Stack()).push(val);
    }
    
    public int pop() {
        int top;
        top = group.get(maxFreq).pop();
        freq.put(top, freq.get(top)-1);
        if(group.get(maxFreq).size()==0){
            maxFreq--;
        }
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// @lc code=end

