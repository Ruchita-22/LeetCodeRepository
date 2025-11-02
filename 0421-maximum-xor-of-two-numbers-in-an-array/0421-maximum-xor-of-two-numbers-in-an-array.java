class TrieNode {
    TrieNode child[] = new TrieNode[2];
    int isEnd = 0;
}
class Solution {
    TrieNode root = new TrieNode();
    public int findMaximumXOR(int[] nums) {
        for(int e : nums) {
            insert(e);
        }
        int ans = 0;
        for(int e : nums) {
            ans = Math.max(ans,search(e));
        }
        
        return ans;
    }
    private void insert(int num) {
        TrieNode curr = root;
        for(int i = 31; i >= 0; i--) {
            if(curr == null) break;
            int p = checkBit(num, i);
            if(curr.child[p] == null) {
                curr.child[p] = new TrieNode();
            }
            curr = curr.child[p];
        }
        curr.isEnd = 1;
    }
    private int search(int num) {
        TrieNode curr = root;
        int ans = 0;
        for(int i = 31; i >= 0; i--) {
            if(curr == null)    break;
            int p = checkBit(num, i);
            if(p == 1) {
                if(curr.child[0] != null) {
                    curr = curr.child[0];
                    ans |= (1<<i);
                } else if(curr.child[1]!=null) {
                    curr = curr.child[1];
                }
            }
            if(p == 0) {
                if(curr.child[1] != null) {
                    curr = curr.child[1];
                    ans |= (1<<i);
                } else if(curr.child[0]!=null) {
                    curr = curr.child[0];
                }
            }
        }
        return ans;
    }
    private int checkBit(int num, int i) {
        return ((num>>i) & 1) == 1 ? 1 : 0;
    }
}