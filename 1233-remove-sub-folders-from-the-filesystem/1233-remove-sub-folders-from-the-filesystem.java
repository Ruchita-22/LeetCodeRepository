class TrieNode{
	    TrieNode children[] = new TrieNode[27];
	    int isEnd = 0;
	}
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        
         for(int i = 0; i < folder.length; i++){
             insert(root, folder[i]);
         }   
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < folder.length; i++){
             String s = prefix(root, folder[i]);
            if(s != null)
                res.add(s);
         }   
        return res;
    }
    private static void insert(TrieNode root, String s){
        TrieNode curr = root;
        for(int i = 0; i < s.length(); i++){
            
            char ci = s.charAt(i);
            if(ci == '/'){
                if(curr.children[26] == null){
                    curr.children[26] = new TrieNode();
                }
                curr = curr.children[26];
            }
            else {
                if(curr.children[ci-'a'] == null){
                    curr.children[ci - 'a'] = new TrieNode();
                }
                curr = curr.children[ci-'a'];
            }   
               
        }
        curr.isEnd = 1;
    }
    private static String prefix(TrieNode root, String s){
        
        TrieNode curr = root;
        
        
        int i = 0;
        for(i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(ci == '/'){
                if(curr.isEnd == 1) break;
                curr = curr.children[26];
            }
            else {
                //if(curr.isEnd == 1) break;
                if(curr.children[ci - 'a'] != null)
                    curr = curr.children[ci-'a'];
            }
        }
        String res = s.substring(0, i);
        if(res == s)    return s;
        else return null;
        
    }
    
}