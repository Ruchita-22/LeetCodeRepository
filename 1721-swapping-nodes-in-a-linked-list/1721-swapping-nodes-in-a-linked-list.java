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
    public ListNode swapNodes(ListNode head, int k) {
        int len=0;
        ListNode p = head;

        while(p!=null){
            len++;
            p=p.next;
        }

        //edge case
        if(k>len || len==1)   return head;

        // set pointer
        ListNode p1=head, p2=head;
        p=head;
        int l=0;
        while(l <= Math.max(k,(len-k+1)) && p!=null){
            l++;
            if(l==k)    p1=p;
            if(l==(len-k+1))   p2=p;
            p=p.next;
        }

        //swap value
        int t = p1.val;
        p1.val = p2.val;
        p2.val = t;

        return head;

    }
}