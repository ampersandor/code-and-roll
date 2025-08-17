import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] fib = new long[]{0, 1};
        if (n < 2){
            System.out.println(fib[n]);
            return;
        }
        long c;
        for (int i = 0; i < n - 1; i++) {
            c = fib[0] + fib[1];
            fib[0] = fib[1];
            fib[1] = c;
        }
        System.out.println(fib[1]);
    }
}
