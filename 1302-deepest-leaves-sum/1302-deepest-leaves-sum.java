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
// application of level order traversal
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)    return 0;
        
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0) {
        	sum = 0;
        	int n = q.size();
        	for (int i = 0; i < n; i++) {
				TreeNode node = q.poll();
				sum += node.val;
				if(node.left != null)	q.add(node.left);
				if(node.right != null)	q.add(node.right);
			}
        }
        return sum;
    }
}