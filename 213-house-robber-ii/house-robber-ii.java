class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        // Case 1: consider houses 0 to n-2
        int[] dp1 = new int[n + 1];
        Arrays.fill(dp1, -1);

        // Case 2: consider houses 1 to n-1
        int[] dp2 = new int[n + 1];
        Arrays.fill(dp2, -1);

        int case1 = solve(0, nums, n - 1, dp1);
        int case2 = solve(1, nums, n, dp2);

        return Math.max(case1, case2);
    }

    public int solve(int i, int[] nums, int n, int[] dp) {

        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int pick = nums[i] + solve(i + 2, nums, n, dp);
        int notPick = solve(i + 1, nums, n, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}