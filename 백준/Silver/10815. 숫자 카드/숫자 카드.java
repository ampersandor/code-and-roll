import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> nums = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums.add(Integer.parseInt(st.nextToken()));
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            bw.write(nums.contains(Integer.parseInt(st.nextToken())) ? "1 " : "0 ");
        }
        bw.flush();
    }
}
