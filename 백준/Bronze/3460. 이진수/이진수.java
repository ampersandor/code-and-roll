import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String func(int num){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0){
            if (num % 2 == 1)
                sb.append(i).append(" ");
            num /= 2;
            i++;
        }
        return sb.toString();

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m;

        while(n-- > 0){
            m = Integer.parseInt(br.readLine());
            System.out.println(func(m));
        }
    }
}