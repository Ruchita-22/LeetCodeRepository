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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int res[][] = new int[m][n];
        for(int t[] : res) {
            Arrays.fill(t, -1);
        }
        
        int t = 0, b = m-1, l = 0, r = n-1;
        ListNode curr = head;
        int dir = 0;
        
        while(t <= b && l <= r){
            if(curr == null)    break;
            
            if(dir == 0) {
                for(int j = l; j <= r; j++){
                    if(curr != null) {
                        res[t][j] = curr.val;
                        curr = curr.next;
                    }
                } 
                t++;
            } 
            else if(dir == 1) {
                for(int i = t; i <= b; i++){
                    if(curr != null) {
                        res[i][r] = curr.val;
                        curr = curr.next;
                    } 
                }
                r--;
            } 
            else if(dir == 2) {
                for(int j = r; j >= l; j--){
                    if(curr != null) {
                        res[b][j] = curr.val;
                        curr = curr.next;
                    } 
                } 
                b--;
            }
            else if(dir == 3) {
                for(int i = b; i >= t; i--){
                    if(curr != null) {
                        res[i][l] = curr.val;
                        curr = curr.next;
                    }
                }
                l++;
            }
            dir = (dir+1) % 4;
        }
        return res;
    }
}