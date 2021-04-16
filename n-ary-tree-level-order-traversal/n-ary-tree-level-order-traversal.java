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
    public List<List<Integer>> levelOrder(Node root) {
        if ( root == null )
            return new ArrayList();
        List<List<Integer>> result = new ArrayList();
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            result.add(new ArrayList());
            for ( int i = 0; i < size; i++){
               Node curr = queue.poll();
               if (curr != null){
                    result.get(level).add(curr.val);
                List<Node> children = curr.children;
                if (children != null){
                    for (Node child : children){
                        queue.offer(child);
                    }
                 }
               }
            }
           level++; 
        }
        return result;
    }
}