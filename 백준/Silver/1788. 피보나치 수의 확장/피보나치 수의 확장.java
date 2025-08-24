import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 1;
        int tmp;
        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
        } else if (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                tmp = b;
                b = (a + b) % MOD;
                a = tmp;
            }
            System.out.println(1);
            System.out.println(b);
        } else {
            n = Math.abs(n);
            for (int i = 0; i < n; i++) {
                tmp = a;
                a = (b - a) % MOD;
                b = tmp;
            }
            System.out.println(Integer.compare(a, 0));
            System.out.println(Math.abs(a));
        }
    }
}
