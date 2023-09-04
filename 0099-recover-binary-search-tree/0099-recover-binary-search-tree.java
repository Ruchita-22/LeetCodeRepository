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
    
    public void recoverTree(TreeNode root) {
        prev = null; first = null; second = null;
        findCulprit(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
    static TreeNode prev = null, first = null, second = null;
    
    private static void findCulprit(TreeNode curr){
        //TreeNode curr = root;
        
        if(curr == null)    return;
        
        findCulprit(curr.left);
        if(prev != null && prev.val > curr.val){
            if(first == null)   first = prev;
            second = curr;
        }
        prev = curr;
        
        findCulprit(curr.right);
    }
    
}