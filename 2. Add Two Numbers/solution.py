# https://leetcode.com/problems/add-two-numbers/

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        ans = ListNode()
        head = ans
        carry = 0
        while True:
            if l1 is l2 is None:
                if carry == 1:
                    head.next = ListNode(1)
                break
            head.next = ListNode()
            head = head.next
            if l1 is None:
                num = l2.val + carry
                l2 = l2.next
            elif l2 is None:
                num = l1.val + carry
                l1 = l1.next
            else:
                num = l1.val + l2.val + carry
                l1 = l1.next
                l2 = l2.next
            if num >= 10:
                num -= 10
                carry = 1
            else:
                carry = 0
            head.val = num
        return ans.next
