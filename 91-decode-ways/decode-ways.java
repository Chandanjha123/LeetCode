class Solution {
    int dp[];
    public int numDecodings(String s) {
        int n = s.length();
        dp=new int[101];
        Arrays.fill(dp,-1);
        return solve(0, s, n,dp);
    }

    public int solve(int i, String s, int n,int []dp) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int checkone = 0;
        int checktwo = 0;
        int oneAlpha = s.charAt(i) - '0';
        if (oneAlpha >= 1 && oneAlpha <= 9) {
            checkone = solve(i + 1, s, n,dp);
        }
        if (i != n - 1) {
            String twoAlpha = "" + s.charAt(i) + s.charAt(i + 1);
            int twoAlphabet = Integer.parseInt(twoAlpha);
            if (twoAlphabet >= 10 && twoAlphabet <= 26) {
                checktwo = solve(i + 2, s, n,dp);
            }
        }
        return dp[i]=checkone + checktwo;
    }
}