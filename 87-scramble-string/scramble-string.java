class Solution {

    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return solve(s1, s2);
    }

    public boolean solve(String a, String b) {

        // 1. Length must be same
        if (a.length() != b.length()) {
            return false;
        }

        // 2. If both strings are exactly same
        if (a.equals(b)) {
            return true;
        }

        // 3. A single character cannot be scrambled into a different character
        if (a.length() <= 1) {
            return false;
        }

        // 4. Create a unique key for this pair
        String key = a + "#" + b;

        // 5. If already calculated, return stored answer
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int n = a.length();

        // Try every possible partition
        for (int i = 1; i <= n - 1; i++) {

            // CASE 1: No swap
            boolean noSwap =
                    solve(a.substring(0, i), b.substring(0, i))
                    &&
                    solve(a.substring(i), b.substring(i));

            // CASE 2: Swap
            boolean swap =
                    solve(a.substring(0, i), b.substring(n - i))
                    &&
                    solve(a.substring(i), b.substring(0, n - i));

            if (noSwap || swap) {
                dp.put(key, true);
                return true;
            }
        }

        // No partition worked
        dp.put(key, false);
        return false;
    }
}