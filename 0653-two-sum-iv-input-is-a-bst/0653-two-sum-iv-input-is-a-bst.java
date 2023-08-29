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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)  return k == 0 ? true : false; 
       
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(q.size()>0){
            TreeNode node = q.poll();
            
            if(set.contains(k-node.val))    return true;
            set.add(node.val);
            
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
            
        }
        return false;
        
        
    }
}