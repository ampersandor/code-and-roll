import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main{

    public static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while ((input = System.in.read()) > 32) {
            num = ((num << 3) + (num << 1)) + (input & 15);
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        int n = read();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] target = new int[n];
        int ptr = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            target[i] = read();
        }
        for (int i = 1; i <= n; i++) {
            if (i <= target[ptr]) {
                stack.push(i);
                sb.append("+").append("\n");
            } else {
                break;
            }
            while (!stack.isEmpty() && stack.peek() == target[ptr]) {
                stack.pop();
                sb.append("-").append("\n");
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