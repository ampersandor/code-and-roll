class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[1000];
        Arrays.fill(map, -1);
        boolean[] tset = new boolean[1000];
        for (int i = 0; i < s.length(); i++) {
            int sc = s.charAt(i);
            int tc = t.charAt(i);
            if (map[sc] != -1 && map[sc] != tc) return false;
            if (map[sc] == -1 && tset[tc]) return false;
            map[sc] = tc;
            tset[tc] = true;
        }
        return true;
    }
}