import java.util.List;

/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list.*/
// class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }
class Solution {
    public ListNode sortList(ListNode head) {
        head.next = sortList(head.next);
        ListNode cur = head.next;
        ListNode prev = head;
        ListNode ans;
        if(head.next == null || head.val < head.next.val){
            ans = head.next;
        }
        else{
            ans = head;
            return ans;
        }
        while(cur != null || cur.val < head.val){
            cur = cur.next;
            prev = prev.next;
        }
        prev.next = head;
        head.next = cur;
        return ans;
    }
}
// @lc code=end

