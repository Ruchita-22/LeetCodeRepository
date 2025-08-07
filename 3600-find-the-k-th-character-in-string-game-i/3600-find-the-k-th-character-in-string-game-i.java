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
        
        int half = 1 << (n-1);
        if(k <= Math.pow(2, n-1) )
            return solve(n-1,k);
        else {
            char ch =  solve(n-1,k-half);
            return (char) (((ch-'a' + 1)%26)+'a');
        }    
        
    }
}