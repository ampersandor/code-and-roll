import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][2];
        boolean[] fixed = new boolean[n + 1];
        for (int i = 0; i < m; i++) fixed[Integer.parseInt(br.readLine())] = true;
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 2; i <= n; i++) {
            if (fixed[i] || fixed[i-1]) {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
            }
            else {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
            }
        }

//        for (int j= 0; j < 2; j++){
//            for (int i = 0; i <= n; i ++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}
