/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {     
       ListNode dummy = new ListNode(0);
       ListNode result = dummy;
       int carry = 0;
       while ( l1 != null || l2 != null)
       {
           int a = l1 != null? l1.val : 0;
           int b = l2 != null? l2.val : 0;
           int sum = a + b + carry;
           result.next = new ListNode(sum % 10);
           carry = sum / 10;
           if ( l1 != null)
               l1 = l1.next;
           if ( l2 != null)
               l2 = l2.next;
           result = result.next;
       }
      if ( carry > 0)
      {
          result.next = new ListNode(carry);
          result = result.next;
      }
      return dummy.next;
    }
}