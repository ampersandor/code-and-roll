import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] walls = new int[m];
        for (int i = 0; i < m; i++){
            walls[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp1 = new int[m];
        int[] dp2 = new int[m];
        dp1[0] = walls[0];
        dp2[m-1] = walls[m-1];
        for (int i = 1; i < m; i++){
            dp1[i] = Math.max(dp1[i-1], walls[i]);
            dp2[m-1-i] = Math.max(dp2[m-i], walls[m-i-1]);
        }

        int res = 0;
        int highest;
        for (int i = 0; i < m; i++){
            highest = Math.min(dp1[i], dp2[i]);
            if (walls[i] < highest){
                res += highest - walls[i];
            }
        }
        bf.write(String.valueOf(res));
        bf.flush();
    }
}
