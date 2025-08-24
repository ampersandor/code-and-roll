import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int j = 0; j < n; j++) {
            for (int i = coins[j]; i <= k; i++){
                dp[i] += dp[i-coins[j]];
            }
        }
//        System.out.println(Arrays.stream(dp).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(dp[k]);
    }
}
