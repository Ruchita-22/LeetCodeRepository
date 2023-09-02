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
    static TreeNode ans;
    static TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        ans = new TreeNode(0);
        curr = ans;
        inorder(root);
        return ans.right;
    }
    private static void  inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        
        TreeNode node = new TreeNode(root.val);
        curr.right = node;
        curr = curr.right;
        
        inorder(root.right);
    }
}