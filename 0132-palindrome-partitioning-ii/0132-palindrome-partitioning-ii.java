class Solution {
    public int isPalindrome(String s,int i,int j,int dp[][])
    {
        if(i>=j)	return 1;
        if(dp[i][j]!=-1)	return dp[i][j];
        if(s.charAt(i)==s.charAt(j) && isPalindrome(s,i+1,j-1,dp) == 1)		dp[i][j]=1;
        else	dp[i][j]=0;
        return dp[i][j];
        
    }
    public int solve(String s,int i,int dp1[],int dp2[][])
    {
        if(i==s.length())	return 0;
        if(isPalindrome(s,i,s.length()-1,dp2)==1)	return 0;
        if(dp1[i]!=-1)	return dp1[i];
        int ans=s.length()-i;
        for(int k=i;k<s.length();k++)
        {
            if(isPalindrome(s,i,k,dp2)==1)
            {
                int tempAns=1+solve(s,k+1,dp1,dp2);
                ans=Math.min(tempAns,ans);
            }
        }
        return dp1[i]=ans;
    }
    public int minCut(String s) {

        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
		
        int dp2[][]=new int[n][n];
        for(int t[] : dp2)
            Arrays.fill(t,-1);
        return solve(s,0,dp,dp2);
        
    }
}