import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] towers = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) towers[i] = Integer.parseInt(st.nextToken());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && towers[stack.peek()] < towers[i]){
                res[stack.pop()] = i+1;
            }
            stack.push(i);
        }

        for (int i = 0; i < n - 1; i ++){
            bw.write(res[i] + " ");
        }
        bw.write(res[res.length - 1] + "");
        bw.flush();


    }
}
