class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int a = 1;
        int b = 2;
        int tmp;
        for (int i = 2; i < n; i++) {
            tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }
}