import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[10001];
        for(int i = 2; i < 5001; i++){
            for(int j = i+i; j < 10001; j += i){
                isNotPrime[j] = true;
            }
        }
        isNotPrime[1] = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int smallest = 0;
        int sum = 0;
        for (int i = a; i <= b; i++){
            if (!isNotPrime[i]){
                if (smallest == 0){
                    smallest = i;
                }
                sum += i;
            }
        }
        if(smallest == 0){
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(smallest);
        }

    }
}