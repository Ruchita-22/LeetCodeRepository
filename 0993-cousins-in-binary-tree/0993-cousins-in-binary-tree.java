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
//https://www.youtube.com/watch?v=4mTFS1ls3ho
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)	return false;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while(q.size()>0) {
    		boolean isXexist = false, isYexist = false;
    		int n = q.size();
    		for (int i = 0; i < n; i++) {
				TreeNode curr = q.poll();
				if(curr.val == x)	isXexist = true;
				if(curr.val == y)	isYexist = true;
				if(curr.left != null && curr.right != null) {
					if( (curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x))
						return false;
				}
                if(curr.left != null)	q.add(curr.left);
				if(curr.right != null)	q.add(curr.right);
				
			}
    		if(isXexist && isYexist)	return true;
    		
    	}
    			
		return false;
    	
    }
}