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
    //Approach 2
    static int curr = 0, currf = 0, maxf = 0;
    static List<Integer> list = null;
    public int[] findMode(TreeNode root) {
        curr = Integer.MIN_VALUE; currf = 0; maxf = 0;
        list = new ArrayList();
        
        inorder(root);
        
        return list.stream().mapToInt(x -> x).toArray();   
        
    }
    public void inorder(TreeNode root) {
        if(root == null) return;
        
        inorder(root.left);
        
        if(root.val == curr) {
            currf++;
            if(maxf < currf) {
                maxf = currf;
                list = new ArrayList(List.of(root.val));
            } else if (maxf == currf) {
                list.add(root.val);
            } 
            else {
                // do nothing
            }
        } else {
            curr = root.val;
            currf = 1;
            if(maxf < currf) {
                maxf = currf;
                list = new ArrayList(List.of(root.val));
            } else if (maxf == currf) {
                list.add(root.val);
            } else {
                // do nothing
            }
        }
        
       
        inorder(root.right);
    }
    // Here preorder traversal wont work as we need to compare the value from root.
    
    // Approach 1
    /*
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
    */
}