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
    static int ans; 
    public int diameterOfBinaryTree(TreeNode root) {
        ans = -1;
        height(root);
        return ans;
    }
    public int height(TreeNode root) {
        if(root == null)    return -1;
        
        int l = height(root.left);
        int r = height(root.right);
        
        ans = Math.max(ans, l+r+2);
        //System.out.println("root="+ root.val + " l="+ l + " r="+r+ " ans="+ ans);
        return Math.max(l,r)+1;
    }
}