class Solution {
    int dp[];
    public int climbStairs(int n) {
       dp=new int[n+1];
       return result(n,dp);
        
    }
    public int result(int n,int[] dp){
        if(n<=1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=result(n-1,dp)+result(n-2,dp);
        return dp[n];
    }
}