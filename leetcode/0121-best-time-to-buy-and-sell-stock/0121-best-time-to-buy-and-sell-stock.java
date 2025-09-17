class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy_best = new int[n];
        int[] sell_best = new int[n];
        buy_best[0] = prices[0];
        sell_best[n-1] = prices[n-1];
        for (int i = 1; i < n; i++){
            buy_best[i] = Math.min(prices[i], buy_best[i-1]);
        }
        for (int i = n - 2; i >= 0; i--){
            sell_best[i] = Math.max(prices[i], sell_best[i+1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            res = Math.max(res, sell_best[i] - buy_best[i]);
        }

        return res;

    }
}