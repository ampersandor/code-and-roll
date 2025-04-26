import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int sum = 0;
        int k = 0;

        for (int i = 1; i < 101 && i * i <= m; i++){
            if (i * i >= n){
                if (k == 0){
                    k = i * i;
                }
                sum += i * i;
            }
        }

        if (k==0){
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(k);
        }
    }
}