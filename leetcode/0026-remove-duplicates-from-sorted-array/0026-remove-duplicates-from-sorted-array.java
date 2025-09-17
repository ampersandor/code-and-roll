class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        
        while (i < nums.length && j < nums.length) {
            nums[i] = nums[j];
            while (j < nums.length - 1 && nums[i] == nums[j+1]) {
                nums[++j] = 0;
            }
            i++;
            j++;
        }
        return i;
    }
}