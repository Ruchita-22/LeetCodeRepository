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
    static Map<Integer, List<TreeNode>> map;
    public List<TreeNode> allPossibleFBT(int n) { 
        map = new HashMap();
        return solve(n);
    }
    public List<TreeNode> solve(int n) {
        if(n % 2 == 0)  return new ArrayList();
        if(n == 1) {
            TreeNode root = new TreeNode(0);
            return List.of(root);
        }
        if(map.containsKey(n))  return map.get(n);
        
        List<TreeNode> res = new ArrayList();
        for(int i = 1; i < n; i += 2){
             List<TreeNode> leftL = solve(i);
             List<TreeNode> rightL = solve(n-i-1);
             for(TreeNode left : leftL) {
                 for(TreeNode right : rightL) {
                     TreeNode root = new TreeNode(0);
                     root.left = left;
                     root.right = right;
                     res.add(root);
                 }
             }
             
         }
        map.putIfAbsent(n, res);
        return res;
    }
}