import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        int cur = 0;

        for (int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cur -= Integer.parseInt(st.nextToken());
            cur += Integer.parseInt(st.nextToken());
            res = Math.max(res, cur);
        }
        System.out.println(res);

    }
}