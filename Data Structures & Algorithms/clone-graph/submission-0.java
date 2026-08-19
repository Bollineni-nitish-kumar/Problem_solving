/*
Definition for a Node.
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
*/

class Solution {

    public Node cloneGraph(Node node) {
         Map<Node, Node> ogVsClone = new HashMap<>();
        return clone(node,ogVsClone);
    }

    private Node clone (Node node,Map<Node, Node> ogVsClone){       
        if(node == null){
            return null;
        }
        if(ogVsClone.containsKey(node)){
            return ogVsClone.get(node);
        }

        Node root = new Node(node.val);
        ogVsClone.put(node,root);

        for(Node nn : node.neighbors){
            root.neighbors.add(clone(nn,ogVsClone));
        }
        return root;

    }
}