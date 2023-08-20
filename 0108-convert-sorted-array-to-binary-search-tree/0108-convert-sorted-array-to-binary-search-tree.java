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
    public TreeNode sortedArrayToBST(int[] arr) {
        return build(0, arr.length-1, arr);
        
    }
    private static TreeNode build(int s, int e, int arr[]){
        if(s>e) return null; 
        
        int m = s+(e-s)/2;
        TreeNode root = new TreeNode(arr[m]);
        root.left = build(s, m-1, arr);
        root.right = build(m+1, e, arr);
        
        return root;
        
    }
}