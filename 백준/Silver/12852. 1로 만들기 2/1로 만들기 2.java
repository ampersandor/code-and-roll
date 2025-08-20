import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] trace = new int[n+1];
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        trace[n] = n;
        for (int i = n; i > 0; i-- ){
            if (i % 2 == 0 && dp[i / 2] > dp[i] + 1) {
                dp[i / 2] = dp[i] + 1;
                trace[i / 2] = i;
            }
            if (i % 3 == 0 && dp[i / 3] > dp[i] + 1) {
                dp[i / 3] = dp[i] + 1;
                trace[i / 3] = i;
            }
            if (dp[i - 1] > dp[i] + 1) {
                dp[i - 1] = dp[i] + 1;
                trace[i - 1] = i;
            }
        }

        System.out.println(dp[1]);
        Deque<Integer> res = new ArrayDeque<>();
        int cur = 1;
        while (cur < n) {
            res.push(cur);
            cur = trace[cur];
        }
        bw.write(n + " ");
        while (!res.isEmpty()) {
            bw.write(res.poll() + " ");
        }
        bw.flush();



    }


}