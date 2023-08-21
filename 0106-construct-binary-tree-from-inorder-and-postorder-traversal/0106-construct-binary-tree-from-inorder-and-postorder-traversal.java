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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder,inorder,0,postorder.length-1, 0, inorder.length-1);
        
    }
    
    private static TreeNode build(int[] postorder, int[] inorder, int ps, int pe, int is, int ie)     {
        if(ps>pe||is>ie)   return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int index = -1;
        for(int i=is; i<=ie;i++){
            if(inorder[i]==postorder[pe]){
                index=i;
                break;
            }
        }
        int len = index-1-is+1;

        root.left = build(postorder,inorder,ps,ps+len-1 ,is,index-1);
        root.right = build(postorder,inorder,ps+len,pe-1,index+1,ie);
        return root;
    }
}