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
    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        
        int level = 1,sumL = 0;
        int ansL = -1, ansSum = Integer.MIN_VALUE;
        
        q.add(root);
        q.add(null);
        
        while(q.size()>0){
            
            TreeNode n = q.poll();
            
            if(n != null){
                sumL += n.val;
                if(n.left != null)  q.add(n.left);
                if(n.right != null)  q.add(n.right);
            }
            
            else{
                if(ansSum < sumL){
                    ansSum = sumL;
                    ansL = level;
                }
                level++; 
                sumL = 0;
                if(q.size()>0) q.add(null);
            }
            
        }
        return ansL;
            
        
    }
}