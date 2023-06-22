class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][]= new int[prices.length+1][2];
       for(int t[] : dp){
           Arrays.fill(t,-1);
       }
       return solve2(0,1,prices, fee, dp);
        
    }
    private static int solve2(int i, int buy, int prices[],int fee,int dp[][]){
       if(i==prices.length )    return 0;
       if(dp[i][buy] != -1) return dp[i][buy];
       int profit = 0;
       if(buy==1){
           int buyKaro = -prices[i] + solve2(i+1,0,prices,fee,dp);
           int skipKaro = solve2(i+1,1,prices,fee,dp);
           profit = Math.max(buyKaro, skipKaro);
       }
       else{
           int sellKaro = prices[i] - fee + solve2(i+1,1,prices,fee,dp);
           int skipKaro = solve2(i+1,0,prices,fee,dp);
           profit = Math.max(sellKaro, skipKaro);
       }
       return dp[i][buy] = profit;
   }
}