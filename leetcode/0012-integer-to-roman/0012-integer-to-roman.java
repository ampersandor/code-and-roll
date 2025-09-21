class Solution {
    public String intToRoman(int num) {
        Map<Integer, Character> map = Map.of(1, 'I', 5, 'V', 10, 'X', 50, 'L', 100, 'C', 500, 'D', 1000, 'M');

        StringBuilder sb = new StringBuilder();
        int lvl = 1;
        while (num > 0){
            int remainder = num % 10;
            if (remainder == 4 || remainder == 9) {
                sb.append(map.get((remainder + 1) * lvl));
                sb.append(map.get(lvl));
            } else if (remainder > 4) {
                for (int i = 0; i < remainder - 5; i++) sb.append(map.get(lvl));
                sb.append(map.get(lvl * 5));
            } else {
                for (int i = 0; i < remainder; i++) sb.append(map.get(lvl));
            }
            lvl *= 10;
            num /= 10;
        }
        return sb.reverse().toString();
    }
}