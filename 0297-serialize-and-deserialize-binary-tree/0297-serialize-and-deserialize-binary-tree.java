/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeNode node = q.poll();
            if(node != null){
                q.add(node.left != null ? node.left : null);
                q.add(node.right != null ? node.right : null);
                sb.append(node.val + " ");
            }
            else{
                sb.append("null ");
            }
         
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(" ");
        if(arr[0].equals("null"))   return null;
        TreeNode root =  new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int i=0;
        
        while(q.size()>0){
            TreeNode node = q.poll();
            
            TreeNode left = arr[i+1].equals("null") ?  null : new TreeNode(Integer.parseInt(arr[i+1]));
            
            TreeNode right = arr[i+2].equals("null") ? null : new TreeNode(Integer.parseInt(arr[i+2]));
            
            node.left = left;
            node.right = right;
            if(left != null)    q.add(left);
            if(right != null)   q.add(right);
            i = i+2;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));