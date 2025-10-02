class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> tset = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc) && map.get(sc) != tc) return false;
            if (!map.containsKey(sc) && tset.contains(tc)) return false;
            map.put(sc, tc);
            tset.add(tc);
        }
        return true;
    }
}