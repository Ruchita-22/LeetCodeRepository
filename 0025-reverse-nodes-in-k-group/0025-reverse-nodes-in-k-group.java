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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2 || !hasSufficient(head, k))   return head;

        ListNode curr = head, prev = null;
        int count = k;
        while(curr != null && count > 0) {
            ListNode np = curr.next;
            curr.next = prev;
            prev = curr;
            curr = np;
            count--;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
    private boolean hasSufficient(ListNode head, int k) {
        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            len++;
            curr = curr.next;
            if(len == k)    return true;
        }
        return false;
    }
}