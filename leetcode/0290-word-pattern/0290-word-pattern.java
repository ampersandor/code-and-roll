class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        boolean[] patternSet = new boolean[26];
        int i = 0;
        for(String word : s.split(" ")) {
            if (map.containsKey(word) && map.get(word) != pattern.charAt(i)) return false;
            if (!map.containsKey(word) && patternSet[pattern.charAt(i) - 97]) return false;
            patternSet[pattern.charAt(i) - 97] = true;
            map.put(word, pattern.charAt(i++));
        }
        return true;

    }
}