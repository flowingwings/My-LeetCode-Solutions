Recent three daily questions are all solvable using binary search. I compared them and finally got a general conclusion on some annoying corner aspects in binary search: 
1. `left < right` or `left == right`?
2. `mid = (left+right)/2` or `mid = right-(right-left)/2`?
3. `left = mid` or `left = mid+1` (the same for `right = mid-1` or `right = mid`)?
A basic principle: **always make sure that the answer always remains in interval [left, right], and abandon unqualified values, and then finally return left.**
Answer to question 1 is simple: use `left < right`. Then when left==right, they are both answers and you can `return left`.
I illustrate a general algorithm using the following template and will fill the blank lines.
```
// variables: left, right, mid
when(left < right) {
 <<assignment1>> // assigns value for mid
 if (<<switchCondition>>) {
  <<assignment2>>
 } else {
  <<assignment3>>
 }
}
return left
// assignment2 and assignment3 are relevant. If assignment2 is left=mid, then assignment3 is right=mid-1, vice versa.
```
Short conclusion: **if possible answers are in the left side, you should have statement `right=mid-1` and `left=mid`, then you should lean to right, so `mid=right-(right-left)/2`. In the contrary condition, do contrary things.**
Analysis: 
In fact, the conditions and assignments you choose depend on the question.
If you are looking for the **maximum value** than satisfies some condition (let's call it `s(mid)==true`), then you have 2 choices:
1. switchCondition:=`s(mid)`. Now mid is a possible answer, and all values on the left are wrong, so assignment2:=`left=mid`, assignment3:=`right=mid-1`.
2. switchCondition:=`!s(mid)`. Now mid is a wrong answer, so assignment2:=`right=mid-1`, assignment3=`left=mid`.
The 2 choices are practically same. Just a different order of 2 branches. Now how to choose assignment1?
The key is that you cannot get into an infinite loop. When `right==left+1`, you still may run `left=mid`, and now mid cannot equal to left, otherwise that's infinite loop. Therefore, when assigning value for mid, you should **lean to right**, thus assignment1:=`mid=right-(right-left)/2` (This one leans to right, because when right==left+1, this statement makes mid equal to right).

If you are looking for the **minimum value**, the condition is similar. Your assignment2&3 are from `left=mid+1` and `right=mid`. Then when assigning value for mid, you should **lean to left**, and assignment1:=`mid=(left+right)/2`.
So In conclusion: if possible answers are in the left side, you should have statement `right=mid-1` and `left=mid`, then you should lean to right, so `mid=right-(right-left)/2`. In the contrary condition, do contrary things.

Besides, if you look for the maximum value for a condition, you are also looking for the minimum value for the contrary condition, so the 2 types of solutions are similar, and it seems that you can use both for one question. But considering that the former answer generally exist and the latter one may not, I suggest you just search for the definitely existing one. 

In this question, you look for a maximum value, so the following code is easily derived:
```java
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int batt: batteries) {
            sum += batt;
        }
        long left = 1; 
        long right = sum / n;
        long mid = 0;
        while(left < right) {
            long target = right-(right-left)/2;
            long cost = 0;
            for(int batt: batteries) {
                cost += Math.min(batt, target);
            }
            if (cost >= (long)n*target) {
                left = target;
            } else {
                right = target-1;
            }
        }
        return left;
    }
}
```

Thanks to leetcode for giving me the same type of questions continuously. It forces me to think deeply, otherwise I would think myself understand binary search by mistake.