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
    HashMap<TreeNode, TreeNode> map = new HashMap();   // child, parent
    public int amountOfTime(TreeNode root, int start) {
        TreeNode target = null;
        Queue<TreeNode> q = new LinkedList();
        
        q.add(root);
        map.put(root, null);
        
        while(q.size() > 0) {
            TreeNode node = q.poll();
            if(node.val == start)   target = node;
            
            if(node.left != null){
                map.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                map.put(node.right, node);
                q.add(node.right);
            }
        }
        
        int time = 0;
        q.clear();
        HashSet<TreeNode> visited = new HashSet();
        
        q.add(target);
        visited.add(target);
        boolean flag = false;
        while(q.size() > 0) {
            int size = q.size();
            flag = false;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if(node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                    flag = true;
                }
                if(node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                    flag = true;
                }
                TreeNode parent = map.get(node);
                if(parent!= null && !visited.contains(parent)) {
                    q.add(parent);
                    visited.add(parent);
                    flag = true;
                }
                //if(flag == true) time++;
            }
            if(flag == true) time++;
            
        }
        return time;        
        
    }

}