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
    public ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        int startIndex = k, endIndex = len-k+1;
        ListNode first = null, second = null;
        curr = head;
        int idx = 1;
         while(curr != null && (first == null || second == null)) {
             if(idx == startIndex) {
                 first = curr;
             } 
             if(idx == endIndex) {
                 second = curr;
             }
             idx++;
             curr = curr.next;
         }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}