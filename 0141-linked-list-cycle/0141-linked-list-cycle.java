/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)   return false;
        ListNode f = head, s = head;
        
        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if(f == s)  return true;
        }
        return false;
        
        
    }
}