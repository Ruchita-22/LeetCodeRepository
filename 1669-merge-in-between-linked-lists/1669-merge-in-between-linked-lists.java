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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list2 == null)   return list1;
        
        ListNode curr = list1;
        ListNode start = null, end = null;
        int idx = 1;
        
        while(curr != null) {
            if(idx == a) start = curr;
            if(idx == b+1) {
                end = curr;
                break;
            }     
            idx++;   
            curr = curr.next;
        }
        
        start.next = list2;
        curr = list2;
        
        while(curr.next != null) {
            curr = curr.next;
        }
        
        curr.next = end.next;
        return list1;
        
    }
}