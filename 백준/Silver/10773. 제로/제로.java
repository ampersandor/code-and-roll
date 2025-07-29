import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int ptr = 0;
        int total = 0;
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                total -= stack[--ptr];
            } else {
                total += num;
                stack[ptr++] = num;
            }
        }
        System.out.println(total);
    }
}