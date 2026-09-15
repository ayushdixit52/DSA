class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = solve(coins, amount, dp);

        return ans == 1000000 ? -1 : ans;
    }

    public int solve(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return 1000000;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int ans = 1000000;

        for (int coin : coins) {
            ans = Math.min(ans, 1 + solve(coins, amount - coin, dp));
        }

        return dp[amount] = ans;
    }
}