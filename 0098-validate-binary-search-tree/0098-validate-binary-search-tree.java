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
    public boolean isValidBST(TreeNode root) {
        
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isBST( TreeNode root, long low, long high){
        if(root == null)    return true;            // 0 node
        //if(root.left==null && root.right == null )  return true;    // 1 node
        if( root.val >= high || root.val <= low) return false;
        
       
        boolean l = isBST(root.left, low, root.val);
        boolean r = isBST(root.right, root.val, high); 
        return l && r;

    }
}