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
// TC: O(N) , N -> no. of nodes of the tree
// SC: O(N) , size of queue -> no. of nodes of the tree
// Did it run successfully on Leetcode? :Yes

 class Solution {
    public Node connect(Node root) {
          //base
          if ( root == null)
            return null;
          dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right){
        //base
         if ( left == null && right == null)
            return;
        //logic
        left.next = right;
        dfs(left.left, left.right);
        dfs(right.left, right.right);
        dfs(left.right, right.left);
         
    }
 }
// TC: O(N) , N -> no. of nodes of the tree
// SC: O(N) , size of queue -> no. of nodes of the tree
// Did it run successfully on Leetcode? :Yes
//  class Solution {
//     public Node connect(Node root) {
//           if ( root == null)
//             return null;
//         Queue<Node> q = new LinkedList();
//         q.offer(root);
//         while (!q.isEmpty())
//         {
//             int size = q.size();
//             Node prev = q.poll();
//             if (prev.left != null)
//             {
//                 q.offer(prev.left);
//             }
//             if (prev.right != null)
//             {
//                 q.offer(prev.right);
//             }
//             for ( int i = 1; i < size; i++)
//             {    
//                Node curr = q.poll();
//                System.out.println("prev "  + prev.val + " curr "  + curr.val);
//                  if (curr.left != null)
//                  {
//                   q.offer(curr.left);
//                  } 
//                  if (curr.right != null)
//                  {      
//                      q.offer(curr.right);
//                  }
//                prev.next = curr;
//                prev = curr;
//             }
//         }
//         return root;
//     }
// }