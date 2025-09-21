class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int zeroIndex = 0;
        long tot = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            }
            else { 
                tot *= nums[i];
            }
        }
        int[] res = new int[nums.length];

        if (zeroCount > 1) {
            return res;
        } else if (zeroCount == 1) {
            res[zeroIndex] = (int) tot;
            return res;
        }

        for (int i = 0; i < nums.length; i++){
            res[i] = (int) tot / nums[i];
        }

        return res;

    }
}