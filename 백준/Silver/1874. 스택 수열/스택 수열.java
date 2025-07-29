import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int[] target = new int[n];
        int ptr = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            target[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (i <= target[ptr]) {
                stack.push(i);
                sb.append("+\n");
            } else {
                break;
            }
            while (!stack.isEmpty() && stack.peek() == target[ptr]) {
                int a = stack.pop();
                sb.append("-\n");
                ptr++;
            }
        }
        if (stack.isEmpty()){
            System.out.println(sb);
        }
        else {
            System.out.println("NO");
        }
    }
}