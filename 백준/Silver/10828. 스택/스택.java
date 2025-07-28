import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch(op) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
        }
    }
}
