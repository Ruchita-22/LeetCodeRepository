/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        return lca(root, a, b);
        
    }
    private static TreeNode lca(TreeNode root, TreeNode a, TreeNode b){
        if(root == null)    return null;
        if(root.val == a.val || root.val == b.val)  return root;
        
        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);
        
        if(left == null)    return right;
        else if(right == null)   return left;
        else return root;
    }
}