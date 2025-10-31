class TrieNode {
    TrieNode[] child = new TrieNode[26];
    int pf = 0, isEnd = 0;
}
class Solution {
    TrieNode root = new TrieNode();
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for(String s : strs) insert(s);
        return findLongestCommonPrefix(strs);
    }
    private void insert(String word) {
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
    /*
    if a node have more than 1 child so cant be prefix of all element 
    if
    */ 
    private String findLongestCommonPrefix(String[] words) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int childIndex = -1;
            int childrenCount = 0;

            // count how many children exist for current node
            for (int i = 0; i < 26 && childrenCount < 2; i++) {
                if (curr.child[i] != null) {
                    childrenCount++;
                    childIndex = i;
                }
            }

            // Stop conditions:
            // 1️⃣ More than one child
            // 2️⃣ End of a word
            // 3️⃣ Not all words share this prefix
            if (childrenCount != 1) break;

            TrieNode next = curr.child[childIndex];
            if (next.pf < words.length) break;

            // Append and move down
            sb.append((char) ('a' + childIndex));
            curr = next;
        }

        return sb.toString();
    }
}