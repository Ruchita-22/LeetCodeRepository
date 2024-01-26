class Solution {
    public int countVowelStrings(int n) {
        return solve(n);
    }
    private static int solve(int n) {
        if(n == 1)  return 5;
        
        int dp[] = new int[6];
        Arrays.fill(dp,1);
        
        int i = 1;
        while(i <= n) {
            for(int j = 4; j>=1; j--) {
                dp[j] = dp[j] + dp[j+1];
            }
            i++;
        }
        
        //print(dp);
        return dp[1];
    }
    private static void print(int arr[]) {
        for(int e : arr){
            System.out.print(e+" ");  
        }
        
        System.out.println();
    }    
    
}