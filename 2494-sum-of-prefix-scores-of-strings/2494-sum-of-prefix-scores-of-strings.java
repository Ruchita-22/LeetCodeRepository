class TrieNode {
    TrieNode child[] = new TrieNode[26];
    int pf = 0, isEnd = 0;
}
class Solution {
    TrieNode root = new TrieNode();
    public int[] sumPrefixScores(String[] words) {
        for(String s : words) {
            insert(s);
        }
        int res[] = new int[words.length];
        int i = 0;
        for(String s : words) {
            int ans = search(s);
            res[i++] = ans;
        }
        return res;

        
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c-'a'] == null) {
                curr.child[c-'a'] = new TrieNode();
            
            }
            curr = curr.child[c-'a'];
            curr.pf++;
        }
        curr.isEnd = 1;
        
    }
    
    public int search(String word) {
        TrieNode curr = root;
        int ans = 0;
        for(char c : word.toCharArray()) {
            //if(curr.child[c-'a'] == null) return ans;
            curr = curr.child[c-'a'];
            ans += curr.pf;
        }
        return ans;
    }
}