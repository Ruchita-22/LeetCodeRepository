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
    static int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        preorder(root, "");
        return sum;
    }
    public void preorder(TreeNode root, String str) {
        if(root == null)    return;
        str += root.val;
        if(root.left == null && root.right == null) {
            sum += Integer.parseInt(str);
        } else {
            preorder(root.left, str);
            preorder(root.right, str);
        }
    }
}