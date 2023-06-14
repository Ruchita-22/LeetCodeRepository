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
    static int ans = Integer.MAX_VALUE;
    static TreeNode prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        
        ans = Integer.MAX_VALUE;
        prev = null;
        
        inorderTraversal(root);
        return ans;
    }
    private static void inorderTraversal(TreeNode root){
        if(root == null)    return;
        
        inorderTraversal(root.left);
        
        if(prev != null){
             int diff = Math.abs(prev.val-root.val);
             ans = Math.min(ans,diff);
        }
        prev = root;
        
        inorderTraversal(root.right);
    }
}