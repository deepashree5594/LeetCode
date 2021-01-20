/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
​
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
​
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
          return null;
        HashMap<Node, Node> map = new HashMap();
        Node original = head;
        Node dummy = new Node(-1);
        Node copyNode = dummy;
        
        // map of original node as key and copyNode as value
        while (original != null)
        {
            copyNode.next = new Node(original.val);
            copyNode = copyNode.next;
            map.put(original, copyNode);
            original = original.next;
        }
        // Copy random pointers for all copyNodes
         original = head;
         copyNode = dummy.next;
        while (original != null )
        {
            copyNode.random = map.get(original.random);
            original = original.next;
            copyNode = copyNode.next;
            
        }
        return dummy.next;
    }
}
