import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    class LinkNode{
        int key;
        int val;
        LinkNode prev;
        LinkNode next;
        public LinkNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    LinkNode head, tail;
    int capacity;
    int size;
    Map<Integer, LinkNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new LinkNode(0, 0);
        tail = new LinkNode(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            LinkNode n = map.get(key);
            // move this node to head
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = head.next;
            n.next.prev = n;
            head.next = n;
            n.prev = head;
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            int sth = get(key);
            head.next.val = value;
            return;
        }
        size += 1;
        if(size > capacity){
            // delete last node
            LinkNode lastNode = tail.prev;
            size -= 1;
            tail.prev = lastNode.prev;
            tail.prev.next = tail;
            map.remove(lastNode.key, lastNode);
        }
        LinkNode n = new LinkNode(key, value);
        n.next = head.next;
        n.prev = head;
        n.next.prev = n;
        head.next = n;
        map.put(key, n);
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

