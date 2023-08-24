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
//https://www.youtube.com/watch?v=U0kqvJTD_cc
// Appliaction of LCA
/*
*/

class Solution {
      int Hmax;
    TreeNode A,B;
    TreeNode ans;
    public int lca(TreeNode node){
        if(node==null)
            return 0;
        
        int sum=lca(node.left)+lca(node.right);
   
        int matched=0;
        if(node.val==A.val)
            matched++;
        if(node.val==B.val)
            matched++;
        
        if(sum+matched==2 && ans==null){
            ans=node;
        }
        
        return sum+matched;
    }
    public void dfs(TreeNode node,int height){
        if(node==null)
            return;
        
        if(height>Hmax){
            Hmax=height;
            A=node;
            B=node;
        }
        else if(height==Hmax){
            B=node;
        }
        
        dfs(node.left,height+1);
        dfs(node.right,height+1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        A=null;
        B=null;
        Hmax=-1;
        
        ans=null;
        dfs(root,0);

        lca(root);
        return ans;
        
    }
}