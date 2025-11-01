class TrieNode {
    TrieNode child[] = new TrieNode[10];
    int pf = 0, isEnd = 0;
}
class Solution {
    TrieNode root = new TrieNode();
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for(int num : arr1) {
            insert(String.valueOf(num));
        }
        int ans = 0;
        for (int num : arr2) {
            String prefix = searchPrefix(String.valueOf(num));
            ans = Math.max(ans,prefix.length());
        }
        return ans;

        
    }
    private void insert(String num) {
        TrieNode curr = root;
        for(char c : num.toCharArray()) {
            if(curr.child[c-'0'] == null) {
                curr.child[c-'0'] = new TrieNode();
            }
            curr = curr.child[c-'0'];
            curr.pf++;
        }
        curr.isEnd = 1;

    }
    private String searchPrefix(String num) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c : num.toCharArray()) {
            if(curr.child[c-'0'] == null) break;
            sb.append(c);
            curr = curr.child[c-'0'];
        }
        return sb.toString();

    }
}