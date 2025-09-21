class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> code = new HashMap<>();
        code.put('I', 1);
        code.put('V', 5);
        code.put('X', 10);
        code.put('L', 50);
        code.put('C', 100);
        code.put('D', 500);
        code.put('M', 1000);
        int res = 0;
        int i = 0; 
        int n = s.length();
        while (i < n) {
            int digit = code.get(s.charAt(i));
            if (i < n - 1 && digit < code.get(s.charAt(i + 1))) {
                res += code.get(s.charAt(i + 1)) - digit;
                i++;
            } else {
                res += digit;
            }
            i++;
        }
        return res;
        
    }
}