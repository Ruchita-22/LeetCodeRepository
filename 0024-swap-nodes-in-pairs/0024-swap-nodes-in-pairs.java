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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode p1= head, p2 = head.next;

        while(p2 != null && p1 != null){
            int temp = p1.val;
            p1.val = p2.val;
            p2.val = temp;
            p1 = p2.next;
            if(p1 !=null)
                p2 = p1.next;
        }
        return head;
    }
}