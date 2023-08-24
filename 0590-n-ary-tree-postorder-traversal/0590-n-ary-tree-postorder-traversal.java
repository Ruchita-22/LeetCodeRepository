/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        solve(root);
        return list;
    }
    static List<Integer> list;
    
    private static  void solve(Node root) {
        if(root ==  null)   return;
        
        
        for(Node node : root.children){
            solve(node);
        }
        list.add(root.val);
    }
}