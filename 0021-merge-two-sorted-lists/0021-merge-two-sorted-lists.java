/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null)   return head2;
        if(head2 == null)   return head1;
        
        ListNode head = new ListNode(0);
        ListNode l1 = head1, l2 = head2, curr = head;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
            curr.next = null;
        }
        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;
        
        return head.next; 
    }
    
}