/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
          if ( root == null)
            return null;
        Queue<Node> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty())
        {
            int size = q.size();
            Node prev = q.poll();
            if (prev.left != null)
            {
                q.offer(prev.left);
                q.offer(prev.right);
            }
            for ( int i = 1; i < size; i++)
            {    
               Node curr = q.poll();
                if (curr.left != null)
                {
                  q.offer(curr.left);
                  q.offer(curr.right);
                }
               prev.next = curr;
               prev = curr;
            }
        }
        return root;
    }
}