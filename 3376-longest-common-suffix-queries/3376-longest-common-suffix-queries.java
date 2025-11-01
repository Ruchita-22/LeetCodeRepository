class TrieNode {
    TrieNode child[] = new TrieNode[26];
    int pf = 0, isEnd = 0;
    int idx = -1,len = Integer.MAX_VALUE;
}
class Solution {
    TrieNode root = new TrieNode();
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        for(int i = 0; i< wordsContainer.length; i++) {
            //System.out.println(reverse(s));
            String reverseStr = reverse(wordsContainer[i]);
            insert(reverseStr,i);
        }
        int res[] = new int[wordsQuery.length];

        for(int i = 0; i< wordsQuery.length; i++) {
            //System.out.println(reverse(s));
            String reverseStr = reverse(wordsQuery[i]);
            res[i] = search(reverseStr);
        }
        return res;
        
    }
    public void insert(String word, int idx) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c-'a'] == null) {
                curr.child[c-'a'] = new TrieNode();
            
            }
            curr = curr.child[c-'a'];
            curr.pf++;
            if(curr.idx == -1 || (curr.len > word.length()) ) {
                curr.idx = idx;
                curr.len = word.length();
            }    
        }
        if(word.length() < root.len) {
            root.idx = idx;
            root.len = word.length();
        }
        curr.isEnd = 1;
        
    }
    
    public int search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c-'a'] == null) return curr.idx;
            curr = curr.child[c-'a'];
        }
        return curr.idx;
    }
    private String reverse(String s) {
        char ch[] = s.toCharArray();
        int i = 0, j = ch.length-1;
        while(i < j) {
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
            i++; j--;
        }
        return new String(ch);
    }
}