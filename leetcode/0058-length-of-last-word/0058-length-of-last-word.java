class Solution {
    public int lengthOfLastWord(String s) {
        String[] splitted = s.trim().split("\\s+");
        return splitted[splitted.length - 1].length();
    }
}