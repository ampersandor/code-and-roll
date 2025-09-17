class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cur] == nums[i] && cur > 0 && nums[cur - 1] == nums[i] ) continue;
            nums[++cur] = nums[i];
        }
        return cur + 1;
    }
}