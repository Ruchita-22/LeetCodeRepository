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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            insert(root, preorder[i]);
        }
        return root;
       
        
    }
    private static void insert(TreeNode root, int val){
        TreeNode p = root, parent = null;
        
        while(p != null){
            parent = p;
            if(val <= p.val)    p = p.left;
            else                p = p.right;
        }
        
        if(val <= parent.val)   parent.left = new TreeNode(val);
        else parent.right = new TreeNode(val);
    }
    
    
}