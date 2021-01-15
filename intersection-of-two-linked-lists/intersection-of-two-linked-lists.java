/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ( headA == null || headB == null)
            return null; 
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        
        ListNode curA = headA;
        ListNode curB = headB;
        
        while (sizeA > sizeB)
        {
             curA = curA.next;
             sizeA--;
        }
        while (sizeB > sizeA)
        {
              curB= curB.next;
              sizeB--;
        }
        
        while ( curA != curB)
        {
             curA = curA.next;
             curB = curB.next;
        }
        
        return curA;
     }
    
    private int getSize(ListNode n)
    {
        int size = 0;
        while ( n != null)
        {
            size++;
            n = n.next;
        }
        return size;
    }
}
​
​
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
​
​
// O(N) time and  O(1) space solution:
​
​
// Step1: Find the size of A and B
// Step2: advance the longest list until they are the same size.
// Step3: search until you find the intersection
// Step4: return either of the nodes, as they are pointing to the intersection.
