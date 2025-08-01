import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int idx = stack.pop();
                res[idx] = nums[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++){
            bw.write(res[i] == 0 ? "-1 " : res[i] + " ");
        }
        bw.flush();
    }
}
