import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = 1;
        for (int i = 2; i <= n; i++){
            m = m * i;
        }

        System.out.println(m);
    }
}
