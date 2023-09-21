class TrieNode {
    TrieNode children[] = new TrieNode[26];
    int pf = 0;
    int  isEnd = 0;
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
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
        TrieNode curr = root;
        for( int i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(curr.children[ci-'a'] == null){
                return false;
            }
            curr = curr.children[ci-'a'];
        }
        return curr.isEnd == 1 ? true : false;
    }
    
    public boolean startsWith(String s) {
        TrieNode curr = root;
        for( int i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(curr.children[ci-'a'] == null){
                return false;
            }
            curr = curr.children[ci-'a'];
        }
        return curr.pf > 0  ? true : false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */