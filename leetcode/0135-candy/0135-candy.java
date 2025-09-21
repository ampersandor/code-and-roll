class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] increasing = new int[n];
        int[] decreasing = new int[n];
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) increasing[i] += increasing[i-1] + 1;
            if (ratings[n-i-1] > ratings[n-i]) decreasing[n-i-1] += decreasing[n-i] + 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            res += Math.max(increasing[i], decreasing[i]);
        }

        return res + n;
    }
}
