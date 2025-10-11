class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closing = Map.of(')', '(', '}', '{', ']', '[');
        for (Character ch : s.toCharArray()) {
            if (closing.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != closing.get(ch)) return false;
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }
}