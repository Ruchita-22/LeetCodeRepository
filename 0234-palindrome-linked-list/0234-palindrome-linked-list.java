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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)   return true;
        
        ListNode s = head, f = head, prev = null;
        while(f != null && f.next != null) {
            prev = s;
            s = s.next;
            f = f.next.next;
        }
    
        if(f != null) s = s.next;
        prev.next =  null;
                
        // now reverse the string
        ListNode head2 = reverse(s);
        
        // now compare
        return compareList(head, head2);
          
    }
    private static ListNode reverse(ListNode head) {
        ListNode curr = head, next = null, prev = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static boolean compareList(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2;
        
        while(p1 != null && p2 != null) {
            if(p1.val != p2.val)    return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    private static void print(ListNode head) {
        ListNode curr = head;
        
        while(curr != null) {
           System.out.print(curr.val+"->");
            curr = curr.next;
        }
         System.out.println();
    }
    
}
