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
    public static List<String> res = null;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList();
        preorder( root, "");
        return res;
        
    }
    public void preorder(TreeNode root, String s) { 
        if(root == null) return;
        
        s += root.val;
        if(root.left == null && root.right == null){
            res.add(new String(s));
        }
        else {
            s += "->";
            preorder(root.left, s);
            preorder(root.right, s);
        }
    }
}