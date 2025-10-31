class TrieNode {
    TrieNode child[] = new TrieNode[26];
    int pf = 0, isEnd = 0;
}
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c-'a'] == null) {
                curr.child[c-'a'] = new TrieNode();
                curr.pf++;
            }
            curr = curr.child[c-'a'];
        }
        curr.isEnd = 1;
        
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c-'a'] == null) return false;
            curr = curr.child[c-'a'];
        }
        return curr.isEnd == 1;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if(curr.child[c-'a'] == null) return false;
            curr = curr.child[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */