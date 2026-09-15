class Solution {
    int dp[];

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return Math.min(solve(0, cost, n,dp),
                        solve(1, cost, n,dp));
    }

    public int solve(int i, int[] cost, int n,int[] dp) {

        if (i >= n) {
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int oneStep = solve(i + 1, cost, n,dp);
        int twoStep = solve(i + 2, cost, n,dp);

        return dp[i]=cost[i] + Math.min(oneStep, twoStep);
    }
}