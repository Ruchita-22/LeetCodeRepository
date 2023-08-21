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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        
    }
    private static TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie){
        if(ps > pe || is > ie)   return null;
        
      
        int val = preorder[ps];
         TreeNode root = new TreeNode(val);
        int idx = -1;
        for(int i = is; i<=ie; i++){
            if(inorder[i]==val){
                idx = i;
                break;
            }
        }  
        int len = idx-1-is+1;
        
        root.left = build(preorder, inorder, ps+1, ps+len, is, idx-1);
        root.right = build(preorder, inorder, ps+len+1, pe, idx+1, ie);
        return root;
    }

}