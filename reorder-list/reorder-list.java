/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if ( head == null || head.next == null ) return;
        ListNode prev = null;
        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l2 = reverse(slow);
        merge(l1,l2);
        
    }
    
    public ListNode reverse(ListNode head)
    {
        ListNode cur = head;
        ListNode prev = null;
        while ( cur != null)
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
           
        }
        return prev;
    }
    public void merge(ListNode l1, ListNode l2)
    {
        while ( l1 != null)
        {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            l1.next = l2;
            if ( l1_next == null )
            {
                break;
            }
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
}
