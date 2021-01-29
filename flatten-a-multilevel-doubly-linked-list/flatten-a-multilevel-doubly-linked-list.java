/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// class Pair{
  
//     Node current;
//     Node next;
//     Pair(Node c, Node n)
//     {
//         this.current = c;
//         this.next = n;
//     }
// }
// class Solution {
    
//     public Node flatten(Node head) {
//         if ( head == null)
//             return null;
//         Stack<Pair> stack = new Stack();
//         Node cur = head;
//         while ( cur != null)
//         {
//             if (cur.child != null)
//             {
//                 stack.push(new Pair(cur, cur.next)); // 3, 4
//                 cur = cur.child;
//             }
//           while ( !stack.isEmpty())
//           {
//             Node start = cur;
//             while ( cur.next != null)
//             {
//                 cur = cur.next;
//             } 
//             Pair p = stack.pop(); // p -> 3, 4
//             cur.next = p.next; //10 -> 4
//             p.next.prev = cur; // 4->10
//             start.prev = p.current;     // 7->3
//             p.current.next = start;  //3->7
//             cur = start; 
//           }
//           cur = cur.next;
//        }
//        return head;
//     }
// }

class Solution {
    public Node flatten(Node head) {
        if ( head == null)
            return null;
        Stack<Node> stack = new Stack();
        Node node = head;
        while (node != null)
        {
            if (node.child != null)
            {
                if (node.next != null)
                 stack.push(node.next);
                
                node.next = node.child;  // next of node to child
                node.next.prev = node; //  prev of child to node
                node.child = null;
               // node = node.next; 
            }
            else if (node.next == null && !stack.isEmpty())
            {
                node.next = stack.pop();
                node.next.prev = node;
            }
                node = node.next;
        }
      return head;
    }
}
