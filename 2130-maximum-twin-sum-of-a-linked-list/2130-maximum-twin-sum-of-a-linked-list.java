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
    public int pairSum(ListNode head) {
        if(head==null || head.next == null) return -1;
        
        ListNode slow = head, fast = head , prev = null;
        
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        
        ListNode list2 = reverseLinkedList(slow);
        ListNode l1 = head , l2 = list2; 
        
        int ans = Integer.MIN_VALUE;
        while(l1 != null && l2 != null){
            ans = Math.max(ans, l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        return ans;
        
    }
    private static ListNode reverseLinkedList(ListNode head){
        ListNode curr = head, next = head, prev = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
        
    }
}