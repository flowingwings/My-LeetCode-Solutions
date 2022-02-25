import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solve {
    
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
// Below is someone's answer.

    // public Node clone(Node node){
    //     if(node == null){
    //         return null;
    //     }
    //     if(map.containsKey(node.val)){
    //         return map.get(node.val);
    //     }
    //     Node newNode = new Node(node.val, new ArrayLide<Node>());
    //     map.put(newNode.val, newNode);
    //     for(Node n: node.neighbors){
    //         newNode.neighbors.add(clone(n));
    //     }
    //     return newNode;
    // }

class Solution {
    public Map<Integer, Node> map = new HashMap<>();
    // public boolean[] visited = new boolean[100];
    public Node cloneGraph(Node node) {
        // Almost wholy copied the code above.
        if(node == null){
            return null;
        }
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }

        Node root = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, root);
        List<Node> rootNeighbors = node.neighbors;
        for(Node n: rootNeighbors){
            // if(!visited[n.val]){
            //     visited[n.val] = true;
            // }
            Node newNode = cloneGraph(n);
            root.neighbors.add(newNode);
        }
        return root;
    }
}