import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        int[] costs = new int[n];
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++){
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
            int next = i + times[i];
            if (next <= n) {
                dp[next] = Math.max(dp[next], dp[i] + costs[i]);
            }
        }
        dp[n] = Math.max(dp[n-1], dp[n]);

        System.out.println(dp[n]);



    }
}
