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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)   return head;

        ListNode prev  = null, curr = head, np = null;
        while(curr != null) {
            np = curr.next;
            curr.next = prev;
            prev = curr;
            curr = np;
        }
        return prev;
    }
}