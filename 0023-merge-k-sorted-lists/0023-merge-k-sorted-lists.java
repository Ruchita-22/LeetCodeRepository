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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 ) return null;
        ListNode head1 = lists[0];
        for(int i = 1; i < lists.length; i++) {
            head1 = merge(head1,lists[i]);
        }
        return head1;
        
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode curr1 = head1, curr2 = head2, next1 = null, next2 = null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(curr1 != null && curr2 != null) {
            if(curr1.val <= curr2.val) {
                next1 = curr1.next;
                curr.next = curr1;
                curr = curr.next;
                curr.next = null;
                curr1 = next1;
            } else if(curr1.val > curr2.val) {
                next2 = curr2.next;
                curr.next = curr2;
                curr = curr.next;
                curr.next = null;
                curr2 = next2;
            }  
        }
        if(curr1 != null) {
            curr.next = curr1;
        }
         if(curr2 != null) {
            curr.next = curr2;
        }
        return dummy.next;
    }
}