import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        char n = br.readLine().toCharArray()[0];
        String arr = br.readLine();
        for (int i = 0; i < 9; i += 2){
            if (arr.charAt(i) == n){
                res ++;
            }
        }
        System.out.println(res);
    }
}