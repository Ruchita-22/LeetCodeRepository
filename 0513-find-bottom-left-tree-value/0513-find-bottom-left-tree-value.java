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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null )   return -1;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int leftMost = root.val;
        
        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                
                TreeNode n = q.poll();
                if(i == 0)  leftMost = n.val;
                
                if(n.left != null)  q.add(n.left);
                if(n.right != null)  q.add(n.right);
            }
        }
        
        return leftMost;
        
    }
}