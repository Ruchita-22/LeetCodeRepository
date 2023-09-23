class TrieNode{
	    TrieNode children[] =  new TrieNode[26];
	    int isEnd = 0;
        String word = null;
}
class Solution {
    public String longestWord(String[] dictionary) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < dictionary.length; i++){
            insert(root, dictionary[i]);
        }
        res = "";
        res = query(root);
        return res;
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
        curr.word = s;
    }
    static String res;
    private static String query(TrieNode root){
        TrieNode curr = root;
        for(int i = 0; i < 26; i++){
            if(curr.children[i] != null && curr.children[i].word != null){
                if(curr.children[i].word.length() > res.length())
                    res = curr.children[i].word;
                query(curr.children[i]);
            }
        }
        return res;
    }    
}