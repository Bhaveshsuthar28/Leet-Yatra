class Solution {
    public int subsequencePairCount(int[] nums) {
        int MOD = 1000000007;
        int mx = 0;

        for (int x : nums)
            mx = Math.max(mx, x);

        long[][] dp = new long[mx + 1][mx + 1];
        dp[0][0] = 1;

        for (int x : nums) {
            long[][] next = new long[mx + 1][mx + 1];

            for (int g1 = 0; g1 <= mx; g1++) {
                for (int g2 = 0; g2 <= mx; g2++) {
                    long cur = dp[g1][g2];

                    if (cur == 0)
                        continue;

                    next[g1][g2] = (next[g1][g2] + cur) % MOD;
                    next[gcd(g1, x)][g2] = (next[gcd(g1, x)][g2] + cur) % MOD;
                    next[g1][gcd(g2, x)] = (next[g1][gcd(g2, x)] + cur) % MOD;
                }
            }

            dp = next;
        }

        long ans = 0;

        for (int g = 1; g <= mx; g++)
            ans = (ans + dp[g][g]) % MOD;

        return (int) ans;
    }

    private static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}