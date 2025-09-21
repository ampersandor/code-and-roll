class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] dp = new int[n];
        dp[0] = gas[0] - cost[0];
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = gas[i] - cost[i] + dp[i-1];
            if (dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }
        if (dp[n-1] < 0) return -1;
        int i = maxIdx;
        while (gas[i] - cost[i] >= 0) i = (i - 1 + n) % n;

        return (i + 1 + n) % n;
    }
}