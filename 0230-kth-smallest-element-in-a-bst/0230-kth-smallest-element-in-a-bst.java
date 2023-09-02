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
    static int ans, i;
    
    public int kthSmallest(TreeNode root, int k) {
        ans = -500;
        i = 0;
        inorder(root, k);
        return ans;
    }
    private static void inorder(TreeNode root, int k){
       if(root == null) return;
        
        inorder(root.left, k);
        
        i++;
        if(i == k)  {
            ans = root.val;;
            return;
        } 
        
        inorder(root.right, k);
       
    }
}