class Solution {
    public char kthCharacter(int k) {
        int n  = 0;
        while(Math.pow(2,n) < k) {
            n++;
        }
        System.out.println(n);
        return solve(n,k);
    }
    public char solve(int n, int k) {
        if(n == 0)  return 'a';
        
        int mid = 1 << (n-1);
        if(k <= mid)
            return solve(n-1,k);
        else {
            char ch =  solve(n-1,k-mid);
            return (char) (((ch-'a' + 1)%26)+'a');
        }    
        
    }
}