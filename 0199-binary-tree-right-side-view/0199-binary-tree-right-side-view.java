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
    public List<Integer> rightSideView(TreeNode root) {
        //    Write your code here.
        if(root == null)    return new ArrayList<Integer>(0);
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
        
		q.add(root);
		q.add(null);
        

	
		while (q.size() > 0) {
			TreeNode x = q.poll();
			if (x != null) {
				
				temp.add(x.val);	
                if (x.left != null)     q.add(x.left);
				if (x.right != null)    q.add(x.right);
				
			} 
            else {
                list.add(temp.get(temp.size()-1));
                temp = new ArrayList<>();
				if(q.size()>0)  q.add(null);
				
			}
		}
		return list;
    
    }
}