class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]) {
                for (String word: wordDict) {
                    if (i + word.length() < dp.length && s.substring(i, i + word.length()).equals(word)) {
                        dp[i+word.length()] = true;
                    }
                }

            }
        }
        return dp[s.length()];
    }
}