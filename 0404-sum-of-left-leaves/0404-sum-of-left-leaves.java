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
class Pair{
    TreeNode node;
    boolean leftChild;
    public Pair(TreeNode node , boolean leftChild){
        this.node = node;
        this.leftChild = leftChild;
    }
}
class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, false));
        int sum = 0;
        
        while(q.size()>0){
            Pair pair = q.poll();
            TreeNode node = pair.node;
                
            if(node.left != null)   q.add(new Pair(node.left, true));
            if(node.right != null)  q.add(new Pair(node.right, false));
            if(node.left == null && node.right == null && pair.leftChild == true){
                sum += node.val;
                System.out.println(node.val);
            }
                
           
        }
        return sum;
        
    }

}