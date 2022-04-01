// https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(true){
            slow = slow.next;
            if(slow == null){
                return null;
            }
            fast = fast.next.next;
            if(fast == null){
                return null;
            }
            if(slow == fast){
                break;
            }
        }
        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}