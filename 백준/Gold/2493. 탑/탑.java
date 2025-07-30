import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] towers = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) towers[i] = Integer.parseInt(st.nextToken());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && towers[stack.peek()] < towers[i]){
                int idx = stack.pop();
                res[idx] = i+1;
            }
            stack.push(i);
        }

        for (int i = 0; i < n - 1; i ++){
            System.out.print(res[i] + " ");
        }
        System.out.print(res[res.length - 1]);



    }
}
