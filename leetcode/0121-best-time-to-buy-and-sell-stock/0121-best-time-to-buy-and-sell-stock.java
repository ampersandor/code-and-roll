class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < n; i++){
            min = Math.min(prices[i], min);
            if (min < prices[i]){
                max = Math.max(prices[i], max);
                res = Math.max(res, prices[i] - min);
            }
        }

        return res;

    }
}