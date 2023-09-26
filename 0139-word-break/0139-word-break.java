//trie
class TrieNode{
    TrieNode children[] = new TrieNode[26];
    int isEnd = 0;
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for(String str : wordDict)    insert(root, str);
        
        boolean[] dp = new boolean[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            if(i == 0 || dp[i-1] == true){
                TrieNode curr = root;
                for(int j = i; j < s.length(); j++){
                    char cj = s.charAt(j);
                    if(curr.children[cj-'a'] == null)   break;
                    curr = curr.children[cj-'a'];
                    if(curr.isEnd == 1) dp[j] = true;
                }
            }
        }
        return dp[s.length()-1];

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
}