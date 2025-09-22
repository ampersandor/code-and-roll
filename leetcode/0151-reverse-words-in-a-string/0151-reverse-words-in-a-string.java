class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");

        return IntStream.range(0, arr.length)
                    .mapToObj(i -> arr[arr.length - 1 - i])
                    .collect(Collectors.joining(" "));
        
    }
}