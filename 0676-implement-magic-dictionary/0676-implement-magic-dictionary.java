class TrieNode{
    TrieNode children[] = new TrieNode[26];
    int isEnd = 0;
}
class MagicDictionary {
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i = 0; i < dictionary.length; i++){
            insert(root, dictionary[i]);
        }
    }
    
    public boolean search(String searchWord) {
        return query(root, searchWord, 0, 1) == 1 ? true : false;
    }
    private static void insert(TrieNode root, String s){
        TrieNode curr = root;
        for(int i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(curr.children[ci-'a'] == null){
                curr.children[ci - 'a'] = new TrieNode();
            }
            curr = curr.children[ci-'a'];
        }
        curr.isEnd = 1;
    }
    private static int query(TrieNode root, String str, int pos, int flag){
        TrieNode curr = root;  
        if(pos == str.length()) {
            if(curr.isEnd == 1 && flag == 0) return 1;
            return 0;    
        }    
        char c = str.charAt(pos);
        int ok=0;
        if(curr.children[c-'a'] != null){
            ok = query(curr.children[c-'a'], str,pos+1,flag);
        }
        if(ok==1)   return 1;
        if(flag==1){
            for(int i=0;i<26;i++){
                if(curr.children[i] != null && i!= (c-'a')){
                    ok = query(curr.children[i], str,pos+1,0);
                }
                if(ok==1)  break;
            }
        }
        return ok;   
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */