class Solution {
    private static final int MAX_VAL = Integer.MAX_VALUE - 1;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX_VAL);
        dp[0] = 1;
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin > 0) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        return dp[amount] == MAX_VAL ? -1 : dp[amount];
    }
}