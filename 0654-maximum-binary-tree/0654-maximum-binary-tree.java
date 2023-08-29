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
    public TreeNode constructMaximumBinaryTree(int[] arr) {
       if(arr.length == 0)  return null;
       return constructMaximumBinaryTreeHelper(arr, 0, arr.length-1);
    }
    private static TreeNode constructMaximumBinaryTreeHelper(int[] arr, int s, int e) {
        int idx = getMax(arr, s, e);
        if(idx == -1)   return null;
        TreeNode root = new TreeNode(arr[idx]);
        root.left = constructMaximumBinaryTreeHelper(arr, s, idx-1);
        root.right = constructMaximumBinaryTreeHelper(arr, idx+1,e);
        return root;   
    }
    private static int getMax(int arr[], int s, int e){
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i = s; i <= e; i++){
            if(arr[i] > max){
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}