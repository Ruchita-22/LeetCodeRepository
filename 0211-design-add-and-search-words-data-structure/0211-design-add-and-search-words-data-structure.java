class TrieNode {
    TrieNode children[] = new TrieNode[26];
    int pf = 0;
    int  isEnd = 0;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String s) {
        TrieNode curr = root;
        for( int i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(curr.children[ci-'a'] == null){
                curr.children[ci-'a']   =   new TrieNode();
            }
            curr = curr.children[ci-'a'];
            curr.pf++;
        }
        curr.isEnd = 1;
    }
    
    public boolean search(String s) {
        // TrieNode curr = root;
        return helper(root, s, 0);
             
       
    }
    private static boolean helper (TrieNode root, String s, int pos){
        if(root == null)    return false;
        if(s.length() == pos) return root.isEnd == 1;
        
        boolean output = false;
        
        if(s.charAt(pos)  == '.') {
            for(int  i = 0; i < 26; i++){
                output = output || helper(root.children[i],  s, pos+1);
            }
        }
        else{
            output = helper(root.children[s.charAt(pos) - 'a'], s, pos+1);
        }
        return output;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */