class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[n-1] = 0;
        int goal = n - 1;
        for (int i = n-2; i >=0; i--) {
            int jumped = Math.min(i + nums[i], n - 1);
            if(jumped >= goal) {
                goal = i;
                for (int j = i; j <= jumped; j++){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[0];
    }
}