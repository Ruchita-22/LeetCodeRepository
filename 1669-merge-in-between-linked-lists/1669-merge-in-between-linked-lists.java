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
        if(list1 == null)   return list2;
        
        ListNode curr = list1;
        ListNode start = null, end = null;
        int idx = 0;
        
        while(curr != null){ 
            if(idx < a) {
                start = curr;
            }
            if(idx == b) {
                end = curr;
            }
            idx++;
            curr = curr.next;
        }
        
        
        start.next = list2;
        while(list2.next != null)    list2 = list2.next;
        list2.next = end.next;
        
        return list1;
        
        
        
    }
}