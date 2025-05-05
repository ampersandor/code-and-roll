import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        int cur = 1;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000];
        for(int i = 0; i < 1000;){
            for(int j = 0; j < cur && i < 1000; j++){
                arr[i++] = cur;
            }
            cur++;
        }
        for(int i = a-1; i < b; i ++){
            res += arr[i];
        }
        System.out.println(res);
    }
}