class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> counter = new HashMap<>();
        for (Character ch: magazine.toCharArray()) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        for (Character  ch : ransomNote.toCharArray()) {
            if (!counter.containsKey(ch) || counter.get(ch) == 0) return false;
            counter.put(ch, counter.get(ch) - 1);
        }

        return true;
    }
}