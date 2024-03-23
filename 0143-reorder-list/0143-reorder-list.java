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
    public void reorderList(ListNode head1) {
        if(head1 == null || head1.next == null)   return;
        
        ListNode f = head1, s = head1, prev = null;
        
        while(f != null && f.next != null){
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        //System.out.println(prev.val);
        //now reverse the LL
        ListNode head2 = s;
        prev.next = null;
        
        head2 = reverse(head2);
        // print(head1);
        // print(head2);
        
        head1 = merge(head1, head2); 
    }
    private static ListNode reverse(ListNode head) {
        ListNode curr = head, np = null, prev = null;
        
        while(curr != null) {
            np = curr.next;
            curr.next = prev;
            prev = curr;
            curr = np;
        }
        return prev;
        
    }
    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, np1 = null, np2 = null, p = head1;
        
        while(p1 != null && p2 != null) {
            np1 = p1.next;
            np2 = p2.next;
            p.next = p2;
            
            if(p.next != null) p = p.next;
            p.next = np1;
            if(p.next != null) p = p.next;
            
            p1 = np1;
            p2 = np2;
        }
        if(p1 != null)    p.next = p1;
        if(p2 !=null)    p.next = p2;
       
        
        return head1;
        
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