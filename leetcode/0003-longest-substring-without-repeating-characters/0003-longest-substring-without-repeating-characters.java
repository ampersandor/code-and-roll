class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= l) {
                l = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - l + 1);                
        }

        return res;
    }
}