import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
// Definition for a Node.

// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        if(head==null)
            return null;
        int val = head.val;
        if(map.containsKey(val)){
            return map.get(val);
        }
        Node nh = new Node(val);
        map.put(val, nh);
        nh.next = copyRandomList(head.next);
        nh.random = copyRandomList(head.random);
        return nh;
    }
}
// @lc code=end

