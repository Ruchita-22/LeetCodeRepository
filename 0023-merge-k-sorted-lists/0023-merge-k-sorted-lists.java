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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)   return null;
        ListNode list1 = lists[0];

        for(int i = 1;  i < lists.length; i++) {
            ListNode list2 = lists[i];
            list1 = mergeTwoLists(list1, list2);
        }
        return list1;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummyHead = new ListNode(-1);
        ListNode curr1 = list1, curr2 = list2, curr = dummyHead;

        while(curr1 != null && curr2 != null) {
            if(curr1.val <= curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
                curr.next = null;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
                curr.next = null;
            }
        }
        if(curr1 != null) {
            curr.next = curr1;
        }
        if(curr2 != null) {
            curr.next = curr2;
        }
        return dummyHead.next;
    }
}