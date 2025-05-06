import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Map<Character, Character> CLOSURE = new HashMap<>();
    public static Map<Character, Integer> SCORES = new HashMap<>();

    public static int solve(String word){
        int res = 0;
        int tmp = 1;
        int i = -1;
        Stack<Character> stack = new Stack<>();
        while (++i < word.length()){
            char ch = word.charAt(i);
            if (CLOSURE.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != CLOSURE.get(ch)) {
                    return 0;
                }
                stack.pop();
                res += tmp;
                tmp /= SCORES.get(CLOSURE.get(ch));
                while (i + 1 < word.length() && CLOSURE.containsKey(word.charAt(i + 1))) {
                    if (stack.isEmpty() || stack.peek() != CLOSURE.get(word.charAt(i + 1))){
                        return 0;
                    }
                    tmp /= SCORES.get(CLOSURE.get(word.charAt(++i)));
                    stack.pop();
                }
            }
            else{
                stack.push(ch);
                tmp *= SCORES.get(ch);
            }
        }
        if(!stack.isEmpty()) return 0;

        return res;

    }
    public static void main(String[] args) throws IOException {
        CLOSURE.put(')', '(');
        CLOSURE.put(']', '[');
        SCORES.put('(', 2);
        SCORES.put('[', 3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(br.readLine()));
    }
}