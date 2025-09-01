import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) weights[i] = Integer.parseInt(br.readLine());
        Arrays.sort(weights);
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (weights[i] * (n - i) > max) {
                max = weights[i] * (n - i);
            }
        }
        System.out.println(max);

    }
}