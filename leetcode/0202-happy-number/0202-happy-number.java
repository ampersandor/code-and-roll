class Solution {
    public String hash(int num) {
        StringBuilder sb = new StringBuilder();
        int[] counter = new int[10];
        while (num > 0) {
            counter[num % 10]++;
            num /= 10;
        }
        for (int count : counter) {
            sb.append(count).append('#');
        }
        return sb.toString();
    }

    public boolean isHappy(int n) {
        Set<String> cache = new HashSet<>();
        while (true) {
            int num = 0;
            while (n > 0) {
                num += Math.pow(n%10, 2);
                n /= 10;
            }
            if (num == 1) return true;
            n = num;
            String hashed = hash(num);
            if (cache.contains(hashed)) return false;
            cache.add(hashed);
        }
    }
}