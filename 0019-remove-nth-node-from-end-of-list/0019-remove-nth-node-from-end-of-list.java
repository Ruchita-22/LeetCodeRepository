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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        int k = len - n + 1;
        if(k == 1)  return head.next;
        curr = head;
        int count = 1;
        while(curr != null && count < k) {
            if(k == len && count == k-1) {
                curr.next = null;
                return head;
            }
            if(count == k-1) {
                curr.next = curr.next.next;
                return head;
            } else {
                count++;
                curr = curr.next;
            }
        }
        return head;
    }
}