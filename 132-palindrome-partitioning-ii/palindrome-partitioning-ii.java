class Solution {

    int[][] dp;
    boolean[][] isPal;

    public int minCut(String s) {

        int n = s.length();

        dp = new int[n][n];
        isPal = new boolean[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Precompute palindrome
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 1 || isPal[i + 1][j - 1])) {

                    isPal[i][j] = true;
                }
            }
        }

        return solve(s, 0, n - 1);
    }

    int solve(String s, int i, int j) {

        // Base case
        if (i >= j) {
            return 0;
        }

        // Already palindrome
        if (isPal[i][j]) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minimum = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            // Only partition if LEFT part is palindrome
            if (isPal[i][k]) {

                int left = solve(s, i, k);
                int right = solve(s, k + 1, j);

                int temp = left + right + 1;

                minimum = Math.min(minimum, temp);
            }
        }

        return dp[i][j] = minimum;
    }
}