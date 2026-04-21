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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode prev = middleNode(head);
        ListNode m = prev.next;
        prev.next = null;
        ListNode list1 = mergeSort(head);
        ListNode list2 = mergeSort(m);
        return mergeTwoLists(list1, list2);
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head, prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;

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