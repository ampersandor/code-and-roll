class Solution {
    static class Anagrams {
        private static int MOD = 7919;
        private String word;
        public Anagrams(String word) {
            this.word = word;
        }
        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Anagrams)) return false;
            char[] alphas = new char[26];
            for (Character ch: ((Anagrams) other).word.toCharArray()) {
                alphas[ch - 97]++;
            }
            for (Character ch: this.word.toCharArray()) {
                alphas[ch - 97]--;
            }
            for (int i = 0; i < 26; i++) {
                if (alphas[i] != 0) return false;
            }
            return true;
        }
        @Override
        public int hashCode() {
            int code = 0;
            for (Character ch : this.word.toCharArray()) {
                code = (code + (int) ch) % MOD;
            }
            return code;
        }

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Anagrams, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Anagrams key = new Anagrams(str);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str);
        }

        return map.values().stream().toList();
    }
}