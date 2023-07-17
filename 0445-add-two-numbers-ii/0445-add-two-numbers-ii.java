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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null)    return null;
        if(l1 == null && l2 != null)    return l2;
        if(l1 != null && l2 == null)    return l1;
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> output = new Stack<>();
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null){
            stack1.push(p1.val);
            p1 = p1.next;
        }
        while(p2 != null){
            stack2.push(p2.val);
            p2 = p2.next;
        }
        int carry = 0;
        int n = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int f = !stack1.isEmpty() ? stack1.pop() : 0;
            int s = !stack2.isEmpty() ? stack2.pop() : 0;
            n = f + s + carry;            
            output.push(n%10);
            carry = n/10;
        }
        if(carry!=0)
            output.push(carry);
        ListNode head = new ListNode(0);
        ListNode newNode = head;
        while(!output.isEmpty()) {
            newNode.next = new ListNode(output.pop());
            newNode = newNode.next;
        }
        return head.next;
    }
}