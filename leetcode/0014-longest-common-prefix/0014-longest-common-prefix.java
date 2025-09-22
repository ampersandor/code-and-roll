class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        while (i < strs[0].length()) {
            Character ch = strs[0].charAt(i);
            for (String str: strs){
                if (i > str.length() - 1|| str.charAt(i) != ch) return str.substring(0, i);
            }
            i++;
        }

        return strs[0].substring(0, i);

    }
}