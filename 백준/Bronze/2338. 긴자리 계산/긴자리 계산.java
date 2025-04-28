import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.math.BigInteger;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();
        System.out.println(n.add(m));
        System.out.println(n.subtract(m));
        System.out.println(n.multiply(m));

    }
}