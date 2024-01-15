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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)   return head;
        
        int len = 0;
        ListNode curr = head, tail = head;
        
        while(curr !=  null) {
            len++;
            tail = curr;
            curr = curr.next;
        }
        
        if(len <= k) k = k % len;
        if(k == 0)  return head;
        
        int startIndex = len-k+1;
        int idx = 1;
        curr = head;
        
        while(curr != null && idx < startIndex - 1){
            curr = curr.next;
            idx++;
        }
        
        ListNode head2 = curr.next;
        curr.next = null;
        tail.next = head;
        return head2;
    }
}