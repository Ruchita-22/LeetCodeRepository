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
    public void reorderList(ListNode head) {
        if(head==null || head.next == null) return;
        ListNode mid = findMid(head);
        //System.out.println(mid.val);
        ListNode l2 = mid.next;
        mid.next = null;    
        
        l2 = reverseList(l2);
        //System.out.println(l2.val);
        ListNode l1 = head, nl1 = null, nl2 = null, p = head;
        
        while(l1 != null && l2 != null){
            
            nl1 = l1.next;
            nl2 = l2.next;
            
            p.next = l2;
            if(p.next!=null) p = p.next;
            
            p.next = nl1;
            if(p.next!=null)  p = p.next;
            
            l1 = nl1;
            l2 = nl2;
        }
        if(l1!=null)    p.next = l1;
        if(l2!=null)    p.next = l2;
    }
    private static ListNode reverseList(ListNode head){
        if(head == null || head.next == null)   return head;
        
        ListNode p = head, np = null, prev = null;
        
        while(p != null){
            np = p.next;
            p.next = prev;
            prev = p;
            p = np;
        }
        return prev;
    }
    private static ListNode findMid(ListNode head){
        if(head == null || head.next == null)   return head;
        
        ListNode prev = null;
        
        ListNode f = head, s = head;
        while(f != null && f.next != null ){
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        return prev;
    }
}