import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        int[] costs = new int[n];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++){
            dp[i] = Math.max(dp[i], dp[i-1]);
            int next = i + times[i-1] - 1;
            if (next <= n) {
                dp[next] = Math.max(dp[next], dp[i-1] + costs[i-1]);
            }
        }

        System.out.println(dp[n]);



    }
}
