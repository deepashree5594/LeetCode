/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Iterative 
// TC: O(N)
// SC: O(1)
// Did it run successfully on 
class Solution {
    public ListNode reverseList(ListNode head) {
       if (head == null)
           return null;
        ListNode prev = null;
        ListNode cur = head;
        while ( cur != null)
        {
            ListNode temp = cur.next;   
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
