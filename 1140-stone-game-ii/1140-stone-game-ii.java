class Solution {
    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--)
            suffix[i] = suffix[i + 1] + piles[i];

        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);

        return dfs(0, 1);
    }

    private int dfs(int i, int m) {
        if (i >= suffix.length - 1)
            return 0;

        if (2 * m >= suffix.length - 1 - i)
            return suffix[i];

        if (dp[i][m] != -1)
            return dp[i][m];

        int best = 0;

        for (int x = 1; x <= 2 * m; x++)
            best = Math.max(best, suffix[i] - dfs(i + x, Math.max(m, x)));

        return dp[i][m] = best;
    }
}