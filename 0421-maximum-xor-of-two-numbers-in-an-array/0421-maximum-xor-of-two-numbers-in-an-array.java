class TrieNode{
    TrieNode children[] = new TrieNode[2];
    int isEnd = 0;
}
class Solution {
    public int findMaximumXOR(int[] arr) {
        TrieNode root = new TrieNode();
        for(int e : arr){
            insert(root, e);
        }
        int ans = 0;
        for(int e : arr){
            ans = Math.max(ans, search(root, e));
        }
        return ans;
    }
    private static int search(TrieNode root, int n){
        TrieNode curr = root;
        int ans = 0;
        for(int i = 31; i >= 0; i--){
            if(curr == null)    break;
            if(checkBit(n, i) == 1){
                if(curr.children[0] !=  null){
                   curr = curr.children[0];
                    ans |= (1<<i); 
                }
                else curr = curr.children[1];
            }
            else {
                if(curr.children[1] !=  null){
                   curr = curr.children[1];
                    ans |= (1<<i); 
                }
                else curr = curr.children[0];
                
            }
        }
        return ans;
    }
    private static void insert(TrieNode root, int n){
        TrieNode curr = root;
        
        for(int i = 31; i >= 0; i--){
            int currBit = checkBit(n , i);
            if(curr.children[currBit] == null){
                curr.children[currBit] =    new TrieNode(); 
            }
            curr = curr.children[currBit];
        }
        curr.isEnd = 1;
    }
    
    private static int checkBit(int x, int i){
		if (((x >> i) & 1) == 1)  return 1;
        else return 0;
    }
}