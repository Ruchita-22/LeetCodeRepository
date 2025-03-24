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
        if(head == null || head.next == null || k < 2 || !hasSufficientNode(head,k))  return head;

        ListNode curr = head, prev = null, np = null;
        int temp = k;
        while( curr != null && temp > 0) {
            np = curr.next;
            curr.next = prev;
            prev = curr;
            curr = np;
            temp--;
        }
        head.next = reverseKGroup(curr, k);
        return prev;

    }
    private static boolean hasSufficientNode(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
            if(count >= k)  return true;
        }
        return false; 
    }
}