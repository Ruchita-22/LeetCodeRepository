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
    public ListNode removeNodes(ListNode head) {
        // for 0 or 1 node
        if(head ==  null || head.next == null)  return head;
        
        // more than 1 node
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while(p != null){
            if(stack.size() == 0)   stack.push(p);
            else{
                if(stack.peek().val > p.val)   stack.push(p);
                else {
                    while(stack.size()>0 && stack.peek().val < p.val )   {
                        ListNode c = stack.pop();
                        c.next = null;
                        if(stack.size()>0){
                            stack.peek().next = p;
                        }
                    }   
                    stack.push(p);
                }
            }
            p = p.next;
        }
        while(stack.size()>1)   stack.pop();
        return stack.pop();
    }
}