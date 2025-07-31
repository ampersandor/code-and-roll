import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0;
        for (int i = 0; i < n; i++){
            int cur = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= cur){
                stack.pop();
            }
            res += stack.size();

            stack.push(cur);
        }
        System.out.println(res);
    }
}
