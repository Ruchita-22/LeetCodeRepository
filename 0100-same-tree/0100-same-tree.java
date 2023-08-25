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
    public boolean isSameTree(TreeNode a, TreeNode b) {
        return solve(a, b);
    }
    private static boolean solve(TreeNode a, TreeNode b){
        if(a == null && b == null)  return true;
        if(a == null || b == null)  return false;
        if(a.val != b.val ) return false;
        boolean l = solve(a.left, b.left);
        boolean r = solve(a.right, b.right);
        return l && r;
        
    }
}