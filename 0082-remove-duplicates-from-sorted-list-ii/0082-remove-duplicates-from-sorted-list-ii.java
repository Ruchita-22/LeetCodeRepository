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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)   return head;
        
        ListNode headNew = new ListNode(0);
        headNew.next = head;
        ListNode curr = head, prev = headNew;
        
        while(curr != null) {
            if(curr.next != null && curr.val == curr.next.val){
                while(curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                    
                prev.next = curr.next;
                curr = curr.next;
            } else {   
                    prev = prev.next;
                    curr = curr.next;
            }
        }
        
        return headNew.next;
        
        
    }
}