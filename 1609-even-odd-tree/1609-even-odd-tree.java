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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null )   return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(q.size() > 0) {
            int size = q.size();
            int prev = level % 2 == 0 ? -1 : Integer.MAX_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if(level%2 == 0) {
                     if(n.val%2 == 0 )   return false;
                     if(prev >= n.val)   return false;     
                }
                if(level%2 == 1) {
                     if(n.val%2 == 1)   return false;
                     if(prev <= n.val)   return false;  
                }
               
                prev = n.val;
                if(n.left != null)  q.add(n.left);
                if(n.right != null)  q.add(n.right);
            }
            level++;
        }
        
        return true;
        
    }
}