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
    int result = 0;
    public int maxDepth(Node root) {
        if ( root == null)
            return 0;
        dfs(root, 1);
        return result;
    }
        
    private void dfs(Node node, int depth){
        //base
        if (node == null)
            return;
        
        //logic
        result = Math.max(result, depth);
        List<Node> children = node.children;
        for (Node child : children){
            dfs(child, depth+1);
        }     
    }
}