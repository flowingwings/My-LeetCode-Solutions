/**
 * Definition for singly-linked list. */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val=val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode head = ans;
        int carry = 0;
        while(true){
            int num;
            if(l1 == null && l2 == null){
                if(carry == 1){
                    head.next = new ListNode();
                    head.next.val = carry;
                }
                break;
            }
            head.next = new ListNode();
            head = head.next;
            if(l1 == null){
                num = l2.val + carry;
                l2 = l2.next;
            }
            else if(l2 == null){
                num = l1.val + carry;
                l1 = l1.next;
            }
            else{
                num = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(num >= 10){
                num -= 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            head.val = num;
        }
        return ans.next;
    }
}