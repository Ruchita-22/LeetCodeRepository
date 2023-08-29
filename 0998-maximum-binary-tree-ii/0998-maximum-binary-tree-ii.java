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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root.val < val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        else{
            TreeNode curr = root;
            TreeNode prev = root;
            while(curr != null && curr.val > val){
                prev = curr;
                curr = curr.right;
            } 
            
            TreeNode node = new TreeNode(val);
            
            if(curr != null){
                node.left = curr;
            }
            
             prev.right = node;  
            
            return root;
        }
    }
}