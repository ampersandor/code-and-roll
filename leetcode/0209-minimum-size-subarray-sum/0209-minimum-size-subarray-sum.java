class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int tot = 0;
        int res = nums.length + 1;
        while (r < nums.length) {
            tot += nums[r++];
            while (l < r && tot - nums[l] >= target) {
                tot -= nums[l++];
            }
            if (tot >= target) {
                res = Math.min(res, r-l);
            }
        }
        return res < nums.length + 1 ? res : 0;
    }
}