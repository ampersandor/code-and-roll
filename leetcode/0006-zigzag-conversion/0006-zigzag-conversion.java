class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<List<Character>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) res.add(new ArrayList<Character>());
        int bucket = 0;
        int direction = 1;
        for (int i = 0; i < s.length(); i ++) {
            res.get(bucket).add(s.charAt(i));
            bucket += direction;
            if (bucket == numRows - 1) direction = -1;
            else if (bucket == 0) direction = 1;
        }

        StringBuilder sb = new StringBuilder();

        for(List<Character> list : res) {
            for (Character ch : list) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}