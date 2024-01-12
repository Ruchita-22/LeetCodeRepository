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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return build(head, null);
    }
    
    public TreeNode build(ListNode head, ListNode tail) {
        
        ListNode mid = getMiddle(head, tail);
        if(mid == null) return null;
        TreeNode root = new TreeNode(mid.val);
        
        root.left = build(head, mid);
        root.right = build(mid.next, tail); 
               
        return root;
    }
    
    public ListNode getMiddle(ListNode head, ListNode tail) { 
        if(head == tail) return null;
        
        ListNode slow = head, fast = head;
        while(fast != tail && fast.next != tail) {
            slow = slow.next; 
            fast = fast.next.next;
        }
        return slow;
        
    }
}