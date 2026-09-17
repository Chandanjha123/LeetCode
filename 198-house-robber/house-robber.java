class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.max(result(0, nums, n,dp),
                        result(1, nums, n,dp));
    }
    public int result(int i,int[] nums,int n,int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int pick=nums[i]+result(i+2,nums,n,dp);
        int notPick=result(i+1,nums,n,dp);

        return dp[i]=Math.max(pick,notPick);
    }
}