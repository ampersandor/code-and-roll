import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] operator = new int[4];
    public static int[] arr;
    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(arr[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void backtracking(int num, int idx){
        if (idx == n){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i < 4; i++){
            if (operator[i] > 0){
                operator[i]--;
                switch(i){
                    case 0: backtracking(num + arr[idx], idx + 1); break;
                    case 1: backtracking(num - arr[idx], idx + 1); break;
                    case 2: backtracking(num * arr[idx], idx + 1); break;
                    case 3: backtracking(num / arr[idx], idx + 1); break;
                }
                operator[i]++;
            }
        }
    }
}