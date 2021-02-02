/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// TC: O(NlogK);
// SC: O(K)
// Did it run successfully on Leetcode? : Yes

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length == 0)
            return null;
        
       PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for ( ListNode list : lists)
        {
            if (list != null)
              pq.add(list);
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy; 
        while (!pq.isEmpty())
        {
            ListNode minimum = pq.poll();
            result.next = minimum;
            result = result.next;
            if (minimum.next != null)
                pq.add(minimum.next);
        }
        return dummy.next;
    }
}

// while(interval<lists.length){
//         System.out.println(lists.length);
//         for (int i = 0; i + interval< lists.length; i=i+interval*2) {
//             lists[i]=mergeTwoLists(lists[i],lists[i+interval]);            
//         }
//         interval*=2;
//     }