class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        
        int cur = 0;
        for (int i = nums.length - 1; i >= 0; i--){
            if (nums[i] >= cur) cur = 0;
            cur++;
        }
        return cur <= nums[0];
    }
}