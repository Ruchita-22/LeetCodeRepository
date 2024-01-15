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
    public ListNode reverseKGroup(ListNode head, int B) {
        if(head == null || head.next == null || B < 2 || !hasSufficientNode(head, B))
            return head;
        
        int k = B;
        ListNode prev = null, curr = head, np = head;
        
        while(curr != null && k > 0) {
            np = curr.next;
            curr.next = prev;
            prev = curr;
            curr = np;
            k--;
            
        }
        head.next = reverseKGroup(curr, B);
        return prev;
    }
    
    public boolean hasSufficientNode(ListNode head, int B) {
        ListNode curr = head;
        int len = 0;
        while(curr != null && len < B){
            len++;
            curr = curr.next;
        }
        return len == B;
    }
}