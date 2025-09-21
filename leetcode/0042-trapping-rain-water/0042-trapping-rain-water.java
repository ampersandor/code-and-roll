class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];
        fromLeft[0] = height[0];
        fromRight[n-1] = height[n-1];
        for (int i = 1; i < n; i++){
            fromLeft[i] = Math.max(fromLeft[i-1], height[i]);
            fromRight[n-i-1] = Math.max(fromRight[n-i], height[n-i-1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(fromLeft[i], fromRight[i]) - height[i];
        }
        return res;
    }
}