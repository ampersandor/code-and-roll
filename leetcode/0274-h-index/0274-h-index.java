class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int i;
        for (i = 1; i <= n; i ++) {
            if (i > citations[n - i]) break;
        }
        return i - 1;
    }
}