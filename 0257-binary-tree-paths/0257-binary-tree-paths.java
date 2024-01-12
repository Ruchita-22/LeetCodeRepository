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
    public static List<String> res = null;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList();
        //preorder( root, new StringBuilder());
        preorder( root, "");
        return res;
        
    }
    public void preorder(TreeNode root, String sb) { 
        if(root == null) return;
        
        //sb.append(root.val);
        sb += root.val;
        if(root.left == null && root.right == null){
            res.add(new String(sb));
        }
        else {
         
            //sb.append("->");
            sb += "->";
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
    }
}