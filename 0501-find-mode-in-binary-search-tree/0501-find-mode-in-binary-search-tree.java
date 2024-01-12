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
    static HashMap<Integer,Integer> map;
    static int maxf = 0;
    
    public int[] findMode(TreeNode root) {
        map = new HashMap();
        maxf = 0;
        preorder(root);
        
        List<Integer> list = new ArrayList();
        
        for(Integer key : map.keySet()){
            if(map.get(key) == maxf) list.add(key);
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
        
    }
    public void preorder(TreeNode root) {
        if(root == null)    return;
        
        int x = root.val;
        map.put(x, map.getOrDefault(x,0)+1);
        maxf = Math.max(maxf, map.get(x));
        
        preorder(root.left);
        preorder(root.right);
    }
    
}