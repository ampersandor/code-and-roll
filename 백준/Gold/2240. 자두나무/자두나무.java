import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] drops = new int[n+1];
        for (int i = 1; i <= n; i++) drops[i] = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][w+2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < w + 2; j++) {
                int drop = j % 2 == drops[i] % 2 ? 1 : 0;
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + drop;
            }
        }

        System.out.println(Arrays.stream(dp[n]).max().orElse(0));
    }
}
