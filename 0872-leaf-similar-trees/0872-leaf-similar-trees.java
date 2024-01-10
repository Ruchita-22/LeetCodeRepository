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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)  return true;
        if(root1 == null || root2 == null)  return false;
        
        List<Integer> list1 = getLeafNode(root1, new ArrayList<Integer>());
        List<Integer> list2 = getLeafNode(root2, new ArrayList<Integer>());
        return list1.equals(list2);
        
        
    }
    private static List<Integer> getLeafNode(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return list;
        }
        getLeafNode(root.left, list);
        getLeafNode(root.right, list);
        return list;
    }
}