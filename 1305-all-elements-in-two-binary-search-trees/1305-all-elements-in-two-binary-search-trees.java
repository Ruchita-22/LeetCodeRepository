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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)   new ArrayList<>(0);
        List<Integer> list1 = inorder(root1, new ArrayList<>());
        List<Integer> list2 = inorder(root2, new ArrayList<>());
        return merge(list1, list2);
    }
    private static List<Integer> inorder(TreeNode root, List<Integer> list){
        if(root == null)    return null;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
    private static List<Integer> merge(List<Integer> list1, List<Integer> list2){
        if(list1 == null || list1.size() == 0)   return list2;  
        if(list2 == null || list2.size() == 0)   return list1;
        
        List<Integer> res = new ArrayList<>();
        
        int i=0, j=0, k=0;
        while(i < list1.size() && j< list2.size()){
            if(list1.get(i) <= list2.get(j)) {
                res.add(list1.get(i));
                i++; k++;
            }
            else {
               res.add(list2.get(j));
                j++; k++; 
            }
        }
        while(i < list1.size()){
            res.add(list1.get(i));
            i++; k++;
        }
        while(j< list2.size()){
               res.add(list2.get(j));
                j++; k++; 
        }
        return res;
        
        
        
    }
}